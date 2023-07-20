package com.example.dto;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoResponseDto {

    private String id;
    private String title;
    private boolean completed;
    private ProjectResponseDto project;
    private UserResponseDto user;


}
