package com.example.prefiks_a.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "orderTable")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String balloonColor;
    private String balloonSize;
    private String clientName;
    private String clientAddress;


    public Order(String balloonColor, String clientName, String clientAddress) {
        this.balloonColor = balloonColor;
        this.clientName = clientName;
        this.clientAddress = clientAddress;

    }

    public Order() {

    }
}
