package com.example.dto;

import lombok.*;

@Data
public class TodoRequestDto {
    private String title;
    private String projectName;
    private String userId;
}
