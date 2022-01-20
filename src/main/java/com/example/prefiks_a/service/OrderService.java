package com.example.prefiks_a.service;

import com.example.prefiks_a.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    Order placeOrder(String balloonColor, String clientName, String address);
    List<Order> listAll();
    Optional<Order> findByClientName(String text);
}
