package com.example.masfinal.repository;

import com.example.masfinal.model.MedicineComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineComponentRepository extends JpaRepository<MedicineComponent, Long> {
}