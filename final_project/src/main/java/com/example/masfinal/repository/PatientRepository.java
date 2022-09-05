package com.example.masfinal.repository;

import com.example.masfinal.model.Patient;
import com.example.masfinal.model.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Query to get all patient's prescriptions
     * @param id - id of the patient
     * @return list of prescriptions, which was given to particular patient
     */
    @Query("SELECT p.prescriptions FROM Patient p WHERE p.id = :id")
    List<Prescription> getPatientPrescriptions(@Param("id") Long id);

}