package com.example.prefiks_a.repository;

import com.example.prefiks_a.bootstrap.DataHolder;
import com.example.prefiks_a.model.Balloon;
import com.example.prefiks_a.model.Manufacturer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryBalloonRepository {
    public List<Balloon> findAllBalloons(){
        return DataHolder.balloonList;
    }
    public List<Balloon> findAllByNameOrDescription(String text){
        return DataHolder.balloonList.stream().filter(r->r.getName().equals(text) || r.getDescription().equals(text)).collect(Collectors.toList());
    }
    public Optional<Balloon> findById(Long id){
        return DataHolder.balloonList.stream().filter(r->r.getId().equals(id)).findFirst();
    }
    public void deleteById(Long id){
        DataHolder.balloonList.removeIf(r->r.getId().equals(id));
    }
    public Optional<Balloon> save(String name, String description, Manufacturer manufacturer){
        DataHolder.balloonList.removeIf(r->r.getName().equals(name));
        Balloon balloon = new Balloon(name,description,manufacturer);
        DataHolder.balloonList.add(balloon);
        return Optional.of(balloon);
    }
    public void deleteByName(String name){
        DataHolder.balloonList.removeIf(r->r.getName().equals(name));
    }
}
