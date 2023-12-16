package com.example.ColaDistributionApp.web;

import com.example.ColaDistributionApp.models.dto.PlantDTO;
import com.example.ColaDistributionApp.services.PlantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/plant")
public class PlantController {
    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @GetMapping("/plant-add")
    public String getPlant() {
        return "plant-add";
    }

    @PostMapping("/plant-add")
    public String postPlant(@Valid @ModelAttribute(name = "plantDTO") PlantDTO plantDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute ("plantDTO", plantDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.plantDTO",
                            bindingResult);
            return "redirect:plant-add";
        }
        this.plantService.addPlant(plantDTO);

        return "redirect:/";
    }

    @ModelAttribute(name = "plantDTO")
    public PlantDTO plantDTO() {
        return new PlantDTO();
    }
}
