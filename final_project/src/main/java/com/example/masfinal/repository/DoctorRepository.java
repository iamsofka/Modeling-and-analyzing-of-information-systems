package com.example.masfinal.repository;

import com.example.masfinal.model.Doctor;
import com.example.masfinal.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    /**
     * Query to get all doctor's patient based on records in visit table
     * @param id - id of the doctor
     * @return list of patients, which have/had visits to particular doctor
     */
    @Query("SELECT v.patient FROM Visit v WHERE v.doctor.id = :id")
    List<Patient> getAllDoctorPatientsById(@Param("id") Long id);
}