package com.example.prefiks_a.service.impl;

import com.example.prefiks_a.model.Balloon;
import com.example.prefiks_a.model.Manufacturer;
import com.example.prefiks_a.model.exceptions.WrongManufacturerIdException;
import com.example.prefiks_a.repository.InMemoryBalloonRepository;
import com.example.prefiks_a.repository.jpa.BalloonRepository;
import com.example.prefiks_a.service.BalloonService;
import com.example.prefiks_a.service.ManufacturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BalloonServiceImpl implements BalloonService {

    private final BalloonRepository balloonRepository;
    private final ManufacturerService manufacturerService;

    public BalloonServiceImpl(BalloonRepository balloonRepository, ManufacturerService manufacturerService){
        this.balloonRepository = balloonRepository;
        this.manufacturerService = manufacturerService;
    }

    @Override
    public List<Balloon> listAll() {
        return this.balloonRepository.findAll();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return this.balloonRepository.findAllByName(text);
    }

    @Override
    public Optional<Balloon> findBalloonById(Long id) {
        return this.balloonRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        this.balloonRepository.deleteById(id);
    }

    @Override
    public Optional<Balloon> save(String name, String description, Long manufacturerId) {
        Manufacturer manufacturer = this.manufacturerService.findManufacturerById(manufacturerId)
                .orElseThrow(()->new WrongManufacturerIdException(manufacturerId));
        this.balloonRepository.deleteBalloonByName(name);
        return Optional.of(this.balloonRepository.save(new Balloon(name,description,manufacturer)));
    }
}
