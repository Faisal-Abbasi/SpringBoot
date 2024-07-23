package com.faisal.springboottutorial.advices;

import lombok.*;
import org.springframework.http.HttpStatus;
@Data
@Builder
public class ApiError {

    private HttpStatus status;
    private String message;
}
