package com.example.developer_toolbox;

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
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tool name cannot be empty")
    private String toolName;

    @NotBlank(message = "Category cannot be empty")
    private String category;

    @NotBlank(message = "Website cannot be empty")
    private String website;

    @NotBlank(message = "Description cannot be empty")
    private String description;

    @Embedded
    private ToolDetails toolDetails;

    @ElementCollection
    private List<String> features = new ArrayList<>();

    @OneToOne
    private ToolLicense license;
}
