package com.example.masfinal.service;

import com.example.masfinal.dto.*;
import com.example.masfinal.model.*;
import com.example.masfinal.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;

/**
 * Service to handle all application business logic
 */
@Service
public class MainServiceImpl implements MainService {

    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final PrescriptionRepository prescriptionRepository;
    private final MedicineRepository medicineRepository;
    private final DistributorRepository distributorRepository;

    public MainServiceImpl(DoctorRepository doctorRepository, PatientRepository patientRepository, PrescriptionRepository prescriptionRepository, MedicineRepository medicineRepository, DistributorRepository distributorRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.prescriptionRepository = prescriptionRepository;
        this.medicineRepository = medicineRepository;
        this.distributorRepository = distributorRepository;
    }

    /**
     * Method to get list of patient's for particular doctor in the database
     * @param id - id of the doctor
     * @return list with patient basic info
     */
    @Override
    public List<PatientBasicInfoDTO> getAllDoctorPatientById(Long id){
        List<PatientBasicInfoDTO> list = new ArrayList<>();

        for (Patient patient : doctorRepository.getAllDoctorPatientsById(id)) {
            list.add(PatientBasicInfoDTO.builder()
                    .id(patient.getId())
                    .fullName(getFullName(patient))
                    .build());
        }

        return list;
    }

    /**
     * Method to get patient detailed information from database
     * @param id - id of the patient
     * @return patient detailed information dto
     * @throws NoSuchElementException if there is no patient with passed id in the database
     */
    @Override
    public PatientInfoDTO getPatientInfoById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return PatientInfoDTO.builder()
                .id(patient.getId())
                .fullName(getFullName(patient))
                .age(calculateAge(patient))
                .dateOfBirth(patient.getDateOfBirth())
                .address(patient.getAddress())
                .complaints(patient.getComplaints())
                .build();
    }

    /**
     * Method to get prescription list for patient with passed id from database
     * @param id - id of the patient.
     * @return list of prescriptions of patient with passed id
     */
    @Override
    public List<PrescriptionsListDTO> getPatientPrescriptions(Long id) {
        List<PrescriptionsListDTO> list = new ArrayList<>();

        for (Prescription prescription: patientRepository.getPatientPrescriptions(id)) {
            list.add(PrescriptionsListDTO.builder()
                    .id(prescription.getId())
                    .medicineName(prescription.getMedicine().getNameMedicine().toUpperCase())
                    .expiryStatus(getPrescriptionStatus(prescription))
                    .build());
        }
        return list;
    }

    /**
     * Method to get prescription detailed information from database
     * @param id - id of the prescription.
     * @return prescription detailed information
     * @throws NoSuchElementException if there is no prescription with passed id in the database
     */
    @Override
    public PrescriptionInfoDTO getPrescriptionInfoById(Long id) {
        Prescription prescription = prescriptionRepository.findById(id).orElseThrow(NoSuchElementException::new);

        return PrescriptionInfoDTO.builder()
                .id(prescription.getId())
                .medicineName(prescription.getMedicine().getNameMedicine().toUpperCase())
                .status(getPrescriptionStatus(prescription).toUpperCase())
                .description(prescription.getDescription())
                .build();
    }

    /**
     * Method to renew prescription
     * @param id - id of the prescription.
     * @throws NoSuchElementException if there is no prescription with passed id in the database
     */
    @Override
    public void renewPrescription(Long id) {
        Prescription prescription = prescriptionRepository.findById(id).orElseThrow(NoSuchElementException::new);
        prescription.setExpiryDate(LocalDate.now().plusDays(90));
        prescriptionRepository.save(prescription);
    }

    /**
     * Method to get medicine basic info list
     * @return list of medicine basic info
     */
    @Override
    public List<MedicineDTO> getMedicineListForNewPrescription() {
        List<MedicineDTO> list = new ArrayList<>();

        for (Medicine medicine: medicineRepository.findAll()) {
            list.add(MedicineDTO.builder()
                    .id(medicine.getId().toString())
                    .medicineName(medicine.getNameMedicine().toUpperCase())
                    .build());
        }

        return list;
    }

    /**
     * Method to add new prescription to the database for particular patient
     * @param patientId - id of the patient.
     * @param dosage - prescription dosage.
     * @param quantity - prescription quantity.
     * @param description - prescription description.
     * @param medicineId - id of the medicine.
     * @throws NoSuchElementException if there is no medicine or patient with passed id in the database
     */
    @Override
    public void addPrescription(Long patientId, String dosage, String quantity, String description, Long medicineId) {

       Medicine medicine = medicineRepository.findById(medicineId).orElseThrow(NoSuchElementException::new);

       Prescription prescription = new Prescription();
       prescription.setDosage(dosage);
       prescription.setQuantity(quantity);
       prescription.setDescription(description);
       prescription.setMedicine(medicine);
       prescription.setExpiryDate(LocalDate.now().plusDays(90));

        prescriptionRepository.save(prescription);
        Patient patient = patientRepository.findById(patientId).orElseThrow(NoSuchElementException::new);
        patient.getPrescriptions().add(prescription);
        patientRepository.save(patient); // todo check if it works
    }

    /**
     * Method to get patient's full name
     * @param patient - patient
     * @return concatenated patient's full name in uppercase form
     */
    private String getFullName(Patient patient) {
        return patient.getNamePatient().concat(" ").concat(patient.getSurnamePatient()).toUpperCase();
    }

    /**
     * Method to calculate patient's age
     * @param patient - patient
     * @return patient age
     */
    private Integer calculateAge(Patient patient) {
        return LocalDate.now().getYear() - patient.getDateOfBirth().getYear();
    }

    /**
     * Method to make string which is needed to show if prescription is expired or not
     * @param prescription - prescription
     * @return VALID - if prescription is not expired and EXPIRED - if prescription is expired
     */
    private String getPrescriptionStatus(Prescription prescription) {
        if(checkIfPrescriptionIsExpired(prescription))
            return "VALID";
        return "EXPIRED";
    }

    /**
     * Method to check if prescription is expired
     * @param prescription - prescription
     * @return true if prescription is expired, false if not
     */
    private Boolean checkIfPrescriptionIsExpired(Prescription prescription) {
        return prescription.getExpiryDate().isAfter(LocalDate.now());
    }

    /**
     * Method to calculate doctor's years of experience
     * @param doctor - doctor
     * @return years of experience in integer
     *
     * Usage of this method is out of project scope
     */
    private Integer calculateYearsOfExperience(Doctor doctor) {
        return LocalDate.now().getYear() - doctor.getCareerStart().getYear();
    }

    /**
     * Method to create new distributor with multi-aspect implementation. Based on distribution type - different fields
     * will be set to distributor.
     * @param distributorVATNum -
     * @param distributorName -
     * @param distributorLocation -
     * @param priceWithPromotion -
     * @param channelType -
     * @param promotion -
     * @param workingHours -
     * @param distributionMethod -
     * @param distributionType -
     *
     * Usage of this method is out of project scope
     */
    private void createDistributor(Float distributorVATNum, String distributorName, String distributorLocation,
                                   Double priceWithPromotion, String channelType, String promotion,
                                   String workingHours, String distributionMethod, DistributionType distributionType) {

        Distributor distributor = new Distributor();
        distributor.setDistributorVATNum(distributorVATNum);
        distributor.setDistributorName(distributorName);
        distributor.setDistributorLocation(distributorLocation);
        distributor.setPriceWithPromotion(priceWithPromotion);

        if (distributionType.equals(DistributionType.DIRECT)) {
            distributor.setDistributionMethod(distributionMethod);
            distributor.setWorkingHours(workingHours);
        } else {
            distributor.setChannelType(channelType);
            distributor.setPromotion(promotion);
        }

        distributorRepository.save(distributor);
    }
}