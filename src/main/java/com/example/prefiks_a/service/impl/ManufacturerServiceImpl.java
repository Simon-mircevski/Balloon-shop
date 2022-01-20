package com.example.prefiks_a.service.impl;

import com.example.prefiks_a.model.Manufacturer;
import com.example.prefiks_a.repository.jpa.ManufacturerRepository;
import com.example.prefiks_a.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Manufacturer> findAll() {
        return this.manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findManufacturerById(Long id) {
        return this.manufacturerRepository.findById(id);
    }
}
