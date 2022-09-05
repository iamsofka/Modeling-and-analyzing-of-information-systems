package com.example.masfinal.controller;

import com.example.masfinal.service.MainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller, handle all communication between thymeleaf and service
 */
@Controller
public class MainController {

    /**
     * When there will be more doctors in the library with security credentials - will be rewritten not to be hardcoded
     * Now it is out of project scope
     */
    public static final Long DEFAULT_DOCTOR_ID = 1L;

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    /**
     * Endpoint home
     * @return html homepage
     */
    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    /**
     * Endpoint to show list of all patients of particular doctor
     * @return html with list of patients
     */
    @GetMapping("/default_doctor")
    public String getAllDoctorPatientById(Model model) {
        model.addAttribute("patients", mainService.getAllDoctorPatientById(getDefaultDoctorId()));
        return "patients";
    }

    /**
     * Endpoint to show patient info
     * @param patient_id - patient id to get patient info
     * @return html with detailed patient information
     */
    @GetMapping("/patientInfo/{patient_id}")
    public String getPatientInfoById(@PathVariable Long patient_id, Model model) {
        model.addAttribute("patient", mainService.getPatientInfoById(patient_id));
        return "patient_info";
    }

    /**
     * Endpoint to show patient's list of prescriptions
     * @param patient_id - patient id to get patient info
     * @return html with list of patient's prescriptions
     */
    @GetMapping("/patientInfo/{patient_id}/prescriptions/")
    public String getPatientPrescriptions(@PathVariable Long patient_id, Model model) {
        model.addAttribute("prescriptions", mainService.getPatientPrescriptions(patient_id));
        model.addAttribute("patient_id", patient_id);
        return "patient_prescriptions";
    }

    /**
     * Endpoint to show prescription info
     * @param prescription_id - prescription id to get info about particular prescription
     * @return html with detailed prescription information
     */
    @GetMapping("/patientInfo/prescriptions/{prescription_id}")
    public String getPrescriptionInfo(@PathVariable Long prescription_id, Model model) {
        model.addAttribute("prescription", mainService.getPrescriptionInfoById(prescription_id));
        return "prescription_info";
    }

    /**
     * Endpoint to open new prescription form
     * @param patient_id - patient id to get info about patient
     * @return html with form for creating new prescription
     */
    @GetMapping("/patientInfo/{patient_id}/newPrescription")
    public String openNewPrescriptionForPatient(@PathVariable Long patient_id, Model model) {
        model.addAttribute("medicines", mainService.getMedicineListForNewPrescription());
        model.addAttribute("patient", mainService.getPatientInfoById(patient_id));
        return "new_prescription";
    }

    /**
     * Endpoint to create new prescription
     * @param patient_id - patient id to save prescription to particular patient
     * @return html with successful screen
     */
    @PostMapping("/patientInfo/{patient_id}/newPrescription/finish")
    public String createNewPrescriptionForPatient(
            @PathVariable Long patient_id,
            @RequestParam(value = "dosage") String dosage,
            @RequestParam(value = "quantity") String quantity,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "medicineId") Long medicineId
    ) {
        mainService.addPrescription(patient_id, dosage, quantity, description, medicineId);
        return "prescription_create_success";
    }

    /**
     * Endpoint to renew prescription
     * @param prescription_id - prescription id to get info about prescription
     * @return html with successful screen
     */
    @PostMapping("/patientInfo/prescriptions/{prescription_id}/renew")
    public String renewPrescription(@PathVariable Long prescription_id) {
        mainService.renewPrescription(prescription_id);
        return "prescription_renew_success";
    }

    /**
     * Endpoint to handle not implemented features
     * @return html with not implemented message
     */
    @GetMapping("/not_implemented_yet")
    public String getNotImplementedYet(){
        return "not_implemented_yet";
    }

    private Long getDefaultDoctorId() {
        return DEFAULT_DOCTOR_ID;
    }



}
