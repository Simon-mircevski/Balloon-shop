package com.example.prefiks_a.service;

import com.example.prefiks_a.model.Balloon;

import java.util.List;
import java.util.Optional;

public interface BalloonService {
    List<Balloon> listAll();
    List<Balloon> searchByNameOrDescription(String text);
    Optional<Balloon> findBalloonById(Long id);
    void delete(Long id);
    Optional<Balloon> save(String name, String description, Long manufacturerId);
}
