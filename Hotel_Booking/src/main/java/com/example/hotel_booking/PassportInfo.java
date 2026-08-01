package com.example.hotel_booking;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Embeddable
public class PassportInfo {

    @NotBlank(message = "Passport number cannot be empty")
    private String passportNumber;

    @NotBlank(message = "Expiry date cannot be empty")
    private String expiryDate;

    @NotBlank(message = "Country cannot be empty")
    private String country;
}
