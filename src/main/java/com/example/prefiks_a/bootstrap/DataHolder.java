package com.example.prefiks_a.bootstrap;

import com.example.prefiks_a.model.Balloon;
import com.example.prefiks_a.model.Manufacturer;
import com.example.prefiks_a.model.Order;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloonList = new ArrayList<>(10);
    public static List<Order> orderList = new ArrayList<>();
    public static List<Manufacturer> manufacturers = new ArrayList<>();
    //@PostConstruct
    //public void init(){
    //    Manufacturer manufacturer = new Manufacturer("Nike", "USA", "NY");
    //    Manufacturer manufacturer1 = new Manufacturer("Adidas", "USA", "NORCAL");
    //    manufacturers.add(manufacturer);
    //    manufacturers.add(manufacturer1);
    //    balloonList.add(new Balloon("Red Balloon", "Red Balloon" , manufacturer));
    //    balloonList.add(new Balloon("Blue Balloon", "Blue Balloon" , manufacturer));
    //    balloonList.add(new Balloon("Yellow Balloon", "Yellow Balloon" , manufacturer));
    //    balloonList.add(new Balloon("White Balloon", "White Balloon" , manufacturer));
//
    //}
}
