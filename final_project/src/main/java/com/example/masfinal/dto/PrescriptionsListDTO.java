package com.example.masfinal.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * DTO class to handle list of prescriptions for particular patient
 */
@Getter
@Builder
public class PrescriptionsListDTO {
    private final Long id;
    private final String medicineName;
    private final String expiryStatus;
}
