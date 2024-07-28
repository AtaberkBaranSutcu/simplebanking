package com.baran.simplebanking.dto;

import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class AmountDTO {
    @Min(value = 0, message = "Amount must be greater than or equal to 0")
    private double amount;
}
