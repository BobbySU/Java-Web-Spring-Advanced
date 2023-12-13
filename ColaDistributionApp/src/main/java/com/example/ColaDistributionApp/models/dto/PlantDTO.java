package com.example.ColaDistributionApp.models.dto;

import com.example.ColaDistributionApp.models.entity.Product;
import com.example.ColaDistributionApp.models.entity.User;
import com.example.ColaDistributionApp.models.entity.enums.Category;
import com.example.ColaDistributionApp.models.entity.enums.City;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
public class PlantDTO {
    @Size(min = 5, max = 10)
    @NotNull
    private String name;
    @Size(min = 5, max = 25)
    @NotNull
    private String description;
    @NotNull
    private Category category;
    @NotNull
    private City city;
    @NotNull
    private User user;

    private List<Product> products;
}