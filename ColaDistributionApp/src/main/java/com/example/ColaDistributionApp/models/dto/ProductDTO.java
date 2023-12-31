package com.example.ColaDistributionApp.models.dto;

import com.example.ColaDistributionApp.models.entity.Order;
import com.example.ColaDistributionApp.models.entity.Plant;
import com.example.ColaDistributionApp.models.entity.Shop;
import com.example.ColaDistributionApp.models.entity.User;
import com.example.ColaDistributionApp.models.entity.enums.Category;
import com.example.ColaDistributionApp.models.entity.enums.Pack;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    @Size(min = 5, max = 10)
    @NotNull
    private String name;
    @Size(min = 5, max = 25)
    @NotNull
    private String description;
    @NotNull
    private Category category;
    @NotNull
    private Integer quantity;
    @NotNull
    private Pack pack;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Date created = new Date();
//    @NotNull
    private PlantDTO plant;
    private UserDTO user;
    private Order order;
    private Shop shop;
}
