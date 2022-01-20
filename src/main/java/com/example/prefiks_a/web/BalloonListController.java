package com.example.prefiks_a.web;

import com.example.prefiks_a.model.Balloon;
import com.example.prefiks_a.model.Manufacturer;
import com.example.prefiks_a.service.BalloonService;
import com.example.prefiks_a.service.ManufacturerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/controller/balloon")
public class BalloonListController {
    private final BalloonService balloonService;
    private final ManufacturerService manufacturerService;

    public BalloonListController(BalloonService balloonService, ManufacturerService manufacturerService) {
        this.balloonService = balloonService;
        this.manufacturerService = manufacturerService;
    }

    @GetMapping
    public String getBalloonPage(Model model){
        List<Balloon> balloonList = this.balloonService.listAll();
        model.addAttribute("balloonList",balloonList);
        return "listBalloons";
    }
    @GetMapping("/add-balloon")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String addBalloon(Model model){
        List<Manufacturer> manufacturers = this.manufacturerService.findAll();
        model.addAttribute("manufacturerList", manufacturers);
        return "add-balloon";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBalloon(@PathVariable Long id){
        this.balloonService.delete(id);
        return "redirect:/controller/balloon";
    }

    @GetMapping("/edit-balloon/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String editBalloon(@PathVariable Long id, Model model){
        if(this.balloonService.findBalloonById(id).isPresent()){
            Balloon balloon = this.balloonService.findBalloonById(id).get();
            List<Manufacturer> manufacturers = this.manufacturerService.findAll();
            model.addAttribute("SelectedBalloon",balloon);
            model.addAttribute("Manufacturers", manufacturers);
            return "add-balloon";
        }
        return "redirect:/controller/balloon=BalloonNotFound";
    }
    @PostMapping("/select/{id}")
    public String selectColor(@PathVariable Long id, HttpServletRequest req){
        Balloon balloon = this.balloonService.findBalloonById(id).get();
        req.getSession().setAttribute("BalloonColor", balloon);
        return "redirect:/controller/size";
    }
    @PostMapping("/add")
    public String addBalloon(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Long manufacturerId){
        this.balloonService.save(name, description, manufacturerId);
        return "redirect:/controller/balloon";
    }


}
