package com.example.masfinal.dto;

import lombok.Builder;
import lombok.Getter;


/**
 * DTO class to handle detailed prescription information
 */
@Getter
@Builder
public class PrescriptionInfoDTO {
    private final Long id;
    private final String medicineName;
    private final String status;
    private final String description;
}
