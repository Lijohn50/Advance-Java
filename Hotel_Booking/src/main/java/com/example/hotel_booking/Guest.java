package com.example.hotel_booking;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Guest name cannot be empty")
    private String name;

    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Mobile number cannot be empty")
    private String mobile;

    @Embedded
    private PassportInfo passportInfo;

    @ElementCollection
    private List<String> specialRequests = new ArrayList<>();

    @OneToOne
    private Booking booking;
}
