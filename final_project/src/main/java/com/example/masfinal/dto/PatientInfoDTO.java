package com.example.masfinal.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

/**
 * DTO class to handle patient's detailed information
 */
@Getter
@Builder
public class PatientInfoDTO {
    private final Long id;
    private final String fullName;
    private final Integer age;
    private final LocalDate dateOfBirth;
    private final String address;
    private final String complaints;
}
