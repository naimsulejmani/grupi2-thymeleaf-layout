package dev.naimsulejmani.grupi2thymeleaflayout.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String speciality;
}








