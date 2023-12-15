package com.example.ColaDistributionApp.web;

import com.example.ColaDistributionApp.models.dto.PlantDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/plant")
public class PlantController {

    @GetMapping("/plant")
    public String getPlant(){
        return "plant-add";
    }

    @ModelAttribute(name = "plantDTO")
    public PlantDTO plantDTO(){
        return new PlantDTO();
    }
}
