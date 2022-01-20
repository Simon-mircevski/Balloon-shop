package com.example.prefiks_a.web;

import com.example.prefiks_a.model.User;
import com.example.prefiks_a.model.exceptions.InvalidUserCredentialsException;
import com.example.prefiks_a.service.AuthService;
import com.example.prefiks_a.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final UserService userService;
    private final AuthService authService;

    public LoginController(UserService userService,
                           AuthService authService){
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage(Model model){
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model){
        User user = null;
        try{
            user = this.userService.login(request.getParameter("username"), request.getParameter("password"));
            request.getSession().setAttribute("user", user);
            return "redirect:/controller/balloon";
        }
        catch(InvalidUserCredentialsException exception){
            model.addAttribute("hasErrors", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }
}