package com.faisal.springboottutorial.advices;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Locale;
@Data
public class ApiResponse <T>{
    private T data;
    private ApiError error;

    private LocalDateTime localDateTime;

    public ApiResponse(){
        this.localDateTime=LocalDateTime.now();
    }
    public ApiResponse(T data){
        this();
        this.data=data;
    }
    public ApiResponse(ApiError error){
        this();
        this.error=error;
    }
}
