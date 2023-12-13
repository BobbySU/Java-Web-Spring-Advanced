package com.example.ColaDistributionApp.models.dto;

import com.example.ColaDistributionApp.models.entity.Order;
import com.example.ColaDistributionApp.models.entity.Plant;
import com.example.ColaDistributionApp.models.entity.Shop;
import com.example.ColaDistributionApp.models.entity.enums.Position;
import com.example.ColaDistributionApp.models.entity.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    @Size(min = 5, max = 10)
    @NotNull
    private String username;
    @Size(min = 5, max = 10)
    @NotNull
    private String password;
    @Size(min = 5, max = 10)
    @NotNull
    private String fullName;
    @Email
    @NotNull
    private String email;
    @NotNull
    private Role role;
    @NotNull
    private Position position;
    @NotNull
    private Date created;

    private List<Plant> plants;
    private List<Shop> shops;
    private List<Order> orders;
}
