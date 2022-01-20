package com.example.prefiks_a.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/controller/size")
public class BalloonSizeController {
    @GetMapping
    public String getSize(){
        return "selectBalloonSize";
    }

    @PostMapping
    public String postSize(@RequestParam String size,
                           HttpServletRequest req){
        req.getSession().setAttribute("BalloonSize", size);
        return "redirect:/BalloonOrder.do";
    }
}
