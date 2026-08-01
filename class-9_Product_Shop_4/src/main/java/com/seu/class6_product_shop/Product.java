package com.seu.class6_product_shop;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import jdk.jfr.Enabled;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @NotNull(message = "ID is required")
    @Id
    private int id;

    @NotBlank(message = "name cannot blank")
    private String name;

    @NotEmpty(message = "category is required")
    private String category;

    @NotNull(message = "stock is required")
    @PositiveOrZero(message = "stock cannot be negative")
    private int stock;

    @NotNull(message = "price is required ")
    @DecimalMin(value = "0.1", message = "price must be more than 0")
    @DecimalMax(value = "999.99", message = "price must be less than 1000")
    private double price;

}
