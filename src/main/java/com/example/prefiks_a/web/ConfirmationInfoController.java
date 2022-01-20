package com.example.prefiks_a.web;

import com.example.prefiks_a.model.Order;
import com.example.prefiks_a.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/ConfirmationInfo")
public class ConfirmationInfoController {

    private final OrderService orderService;

    public ConfirmationInfoController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getConfirmation(Model model, HttpServletRequest req){
        String client = (String) req.getSession().getAttribute("ClientName");
        model.addAttribute("order",this.orderService.findByClientName(client).get());
        return "confirmationInfo";
    }
}
