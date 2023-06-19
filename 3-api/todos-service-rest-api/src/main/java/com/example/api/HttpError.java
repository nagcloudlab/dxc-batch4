package com.example.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class HttpError {
    private final String path;
    private final int status;
    private final String message;
}
