package it.nicolachiarappa.context.identity.infrastructure.web;

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


    public <T> ApiResponse<T> createErrorResponse(String message, T data){
        return ApiResponse.<T>builder()
                .message(message)
                .data(data)
                .success(false)
                .build();
    }
}
