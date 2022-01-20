package com.example.prefiks_a.service;

import com.example.prefiks_a.model.Manufacturer;

import java.util.List;
import java.util.Optional;

public interface ManufacturerService {
    List<Manufacturer> findAll();
    Optional<Manufacturer> findManufacturerById(Long id);
}
