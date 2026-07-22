package com.seu.class6_product_shop;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @NotNull(message = "ID is required")
    @Size(min = 1, max = 100, message = "ID must be between 1-100")
    private String id;

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
