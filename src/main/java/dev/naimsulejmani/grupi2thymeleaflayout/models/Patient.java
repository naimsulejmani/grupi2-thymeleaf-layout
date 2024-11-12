package dev.naimsulejmani.grupi2thymeleaflayout.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private String name;
    private String surname;
    private String phone;
    private String address;
    private boolean isSick;
}
