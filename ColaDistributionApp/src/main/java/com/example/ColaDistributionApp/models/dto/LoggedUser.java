package com.example.ColaDistributionApp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LoggedUser {
    private String id;
    public boolean isEmpty(){
        return this.id == null;
    }

    public void clearUser(){
        this.id = null;
    }
}
