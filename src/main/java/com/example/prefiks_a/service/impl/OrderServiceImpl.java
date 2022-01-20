package com.example.prefiks_a.service.impl;

import com.example.prefiks_a.bootstrap.DataHolder;
import com.example.prefiks_a.model.Order;
import com.example.prefiks_a.repository.jpa.OrderRepository;
import com.example.prefiks_a.service.OrderService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public Order placeOrder(String balloonColor, String clientName, String address) {
        Order order = new Order(balloonColor,clientName,address);
        this.orderRepository.deleteByClientName(clientName);
        return this.orderRepository.save(order);
    }

    @Override
    public List<Order> listAll() {
        return this.orderRepository.findAll();
    }

    @Override
    public Optional<Order> findByClientName(String text) {
        return this.orderRepository.findByClientName(text);
    }
}
