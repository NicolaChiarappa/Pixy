package it.nicolachiarappa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;

@Component
public class ApiResponseFactory {

    public  <T> ApiResponse<T> createSuccessResponse(String message, T data){
        return ApiResponse.<T>builder()
                .message(message)
                .success(true)
                .data(data)
                .build();
    }


    public  <T> ApiResponse<T> createNotFoundResponse(String message) {
        return ApiResponse.<T>builder()
                .message(message)
                .data(null)
                .success(false)
                .build();
    }
}
