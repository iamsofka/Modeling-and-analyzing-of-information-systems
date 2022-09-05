package com.example.masfinal.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * DTO class to handle list of patients of particular doctor
 */
@Getter
@Builder
public class PatientBasicInfoDTO {
    private final Long id;
    private final String fullName;
}
