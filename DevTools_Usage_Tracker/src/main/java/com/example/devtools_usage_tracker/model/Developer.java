package com.example.devtools_usage_tracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Full Name cannot be empty")
    private String fullName;
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotEmpty(message = "Department cannot be empty")
    private String department;
    @NotEmpty(message = "Join Date cannot be empty")
    private LocalDate joinDate;
}
