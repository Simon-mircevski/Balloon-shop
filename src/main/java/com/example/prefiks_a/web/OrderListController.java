package com.example.prefiks_a.web;

import com.example.prefiks_a.model.Order;
import com.example.prefiks_a.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderListController {
    private final OrderService orderService;

    public OrderListController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getOrders(Model model){
        List<Order> orderList = this.orderService.listAll();
        model.addAttribute("orders",orderList);
        return "userOrders";
    }
}
