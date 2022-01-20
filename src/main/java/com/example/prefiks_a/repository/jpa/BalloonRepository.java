package com.example.prefiks_a.repository.jpa;

import com.example.prefiks_a.model.Balloon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon, Long> {
    List<Balloon> findAllByName(String text);
    void deleteBalloonByName(String text);
}
