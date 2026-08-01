package com.example.class10_dto;

public sealed class  Car permits ElectricCar, WaterCar {

    private int id;
    private String name;
    private int brand;
}
