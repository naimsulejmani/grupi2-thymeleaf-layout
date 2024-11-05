package dev.naimsulejmani.grupi2thymeleaflayout.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class News {
    private String imageUrl;
    private String title;
    private String shortDescription;
    private LocalDate date;
    private String type;
    private LocalDateTime createdAt = LocalDateTime.now();
}


