package com.example.masfinal.service;

import com.example.masfinal.dto.*;

import java.util.List;

public interface MainService {
    List<PatientBasicInfoDTO> getAllDoctorPatientById(Long id);

    PatientInfoDTO getPatientInfoById(Long id);

    List<PrescriptionsListDTO> getPatientPrescriptions(Long id);

    PrescriptionInfoDTO getPrescriptionInfoById(Long id);

    void renewPrescription(Long id);

    List<MedicineDTO> getMedicineListForNewPrescription();

    void addPrescription(Long patientId, String dosage, String quantity, String description, Long medicineId);
}
