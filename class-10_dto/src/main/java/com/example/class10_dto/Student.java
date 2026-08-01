package com.example.class10_dto;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Student {

    private int id;
    private String name;
    private double cgpa;
    private String createdBy;
    private LocalDate createdDate;
}
