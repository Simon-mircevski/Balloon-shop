package com.example.prefiks_a.repository;

import com.example.prefiks_a.bootstrap.DataHolder;
import com.example.prefiks_a.model.Manufacturer;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;

@Repository
public class InMemoryManufacturerRepository {
    public List<Manufacturer> findAll(){
        return DataHolder.manufacturers;
    }
    public Optional<Manufacturer> findById(Long id){
        return DataHolder.manufacturers.stream().filter(r->r.getId().equals(id)).findFirst();
    }
}
