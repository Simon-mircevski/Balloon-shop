package com.example.prefiks_a.web;

import com.example.prefiks_a.model.Balloon;
import com.example.prefiks_a.model.Manufacturer;
import com.example.prefiks_a.model.Order;
import com.example.prefiks_a.service.ManufacturerService;
import com.example.prefiks_a.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/BalloonOrder.do")
public class BalloonOrderController {

    private final OrderService orderService;
    private final ManufacturerService manufacturerService;

    public BalloonOrderController(OrderService orderService, ManufacturerService manufacturerService) {
        this.orderService = orderService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getDelivery(Model model){
        List<Order> orders = this.orderService.listAll();
        model.addAttribute("orders",orders);
        return "deliveryInfo";
    }
    @PostMapping
    public String postDelivery(@RequestParam String clientName,
                               @RequestParam String clientAddress,
                               HttpServletRequest req){
        Balloon balloon = (Balloon) req.getSession().getAttribute("BalloonColor");
        String balloonName = balloon.getName();
        String balloonSize = (String) req.getSession().getAttribute("BalloonSize");

        req.getSession().setAttribute("ClientName",clientName);
        this.orderService.placeOrder(balloonName,clientName,clientAddress);
        return "redirect:/ConfirmationInfo";
    }
}
