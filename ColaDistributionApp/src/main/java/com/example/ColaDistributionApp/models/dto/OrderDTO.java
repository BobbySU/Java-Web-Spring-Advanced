package com.example.ColaDistributionApp.models.dto;

import com.example.ColaDistributionApp.models.entity.Product;
import com.example.ColaDistributionApp.models.entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class OrderDTO {
    @NotNull
    private Date created;
    @NotNull
    private User buyer;

    private List<Product> products;
}
