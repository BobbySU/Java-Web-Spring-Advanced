package com.example.ColaDistributionApp.web;

import com.example.ColaDistributionApp.models.dto.*;
import com.example.ColaDistributionApp.models.entity.User;
import com.example.ColaDistributionApp.services.UserService;
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
@RequestMapping("/user")
public class UserController {
    private final LoggedUser loggedUser;
    private final UserService userService;

    @Autowired
    public UserController(LoggedUser loggedUser, UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister() {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterDTO") UserRegisterDTO userRegisterDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO",
                            bindingResult);
            return "redirect:register";
        }

        this.userService.registerUser(userRegisterDTO);

        return "redirect:login";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute(name = "userLoginDTO") UserLoginDTO userLoginDTO,
                            BindingResult bindingResult,
                            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginDTO",
                            bindingResult);
            return "redirect:login";
        }
        this.userService.loginUser(userLoginDTO);

        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String getLogout() {
        this.userService.logoutUser();
        return "redirect:/";
    }

    @GetMapping("/change-password")
    public String getChange() {
        return "change-password";
    }

    @PostMapping("/change-password")
    public String postChange(@Valid @ModelAttribute(name = "userPassChangeDTO") UserPassChangeDTO userPassChangeDTO,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userPassChangeDTO", userPassChangeDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userPassChangeDTO",
                            bindingResult);
            return "redirect:change-password";
        }
        this.userService.changePass(userPassChangeDTO);

        return "redirect:/home";
    }

    @ModelAttribute(name = "userRegisterDTO")
    public UserRegisterDTO userRegisterDTO() {
        return new UserRegisterDTO();
    }

    @ModelAttribute(name = "userLoginDTO")
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }

    @ModelAttribute(name = "userPassChangeDTO")
    public UserPassChangeDTO userPassChangeDTO() {
        return new UserPassChangeDTO();
    }
}
