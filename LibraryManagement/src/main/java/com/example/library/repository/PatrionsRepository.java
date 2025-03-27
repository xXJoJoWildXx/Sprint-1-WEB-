package com.example.library.repository;

import com.example.library.model.Patrions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatrionsRepository extends JpaRepository<Patrions, Integer> {
    
}
