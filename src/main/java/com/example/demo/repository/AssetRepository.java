package com.example.demo.repository;

import com.example.demo.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
    boolean existsById(Long id);
}
