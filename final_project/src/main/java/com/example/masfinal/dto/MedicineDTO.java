package com.example.masfinal.dto;

import lombok.Builder;
import lombok.Getter;

/**
 * DTO class to handle list of medicines needed when creating new prescription
 */
@Getter
@Builder
public class MedicineDTO {
    private final String id;
    private final String medicineName;
}
