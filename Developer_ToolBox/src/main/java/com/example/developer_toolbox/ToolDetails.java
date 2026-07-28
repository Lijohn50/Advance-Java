package com.example.developer_toolbox;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ToolDetails {

    @NotBlank(message = "Platform cannot be empty")
    private String platform;

    @NotBlank(message = "Version cannot be empty")
    private String version;

    @NotBlank(message = "License cannot be empty")
    private String license;
}
