package com.example.devtools_usage_tracker;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Tool name is required")
    private String name;

//    @NotNull(message = "Category is required")
//    @Enumerated(EnumType.STRING)
//    private ToolCategory category;

    @NotBlank(message = "Vendor is required")
    private String vendor;

//    @NotNull(message = "License type is required")
//    @Enumerated(EnumType.STRING)
//    private LicenseType licenseType;

    @NotNull(message = "Cost per seat is required")
    @PositiveOrZero(message = "Cost per seat cannot be negative")
    private BigDecimal costPerSeat;

    @Min(value = 0, message = "Total seats cannot be negative")
    private int totalSeats;

    @NotNull(message = "Renewal date is required")
    private LocalDate renewalDate;
}
