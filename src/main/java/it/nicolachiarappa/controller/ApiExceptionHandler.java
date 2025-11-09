package it.nicolachiarappa.controller;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    ApiResponseFactory responseFactory;


    @Autowired
    public ApiExceptionHandler(ApiResponseFactory factory){
        this.responseFactory = factory;
    }


    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @NotNull HttpHeaders headers, @NotNull HttpStatusCode status, @NotNull WebRequest request)
    {
        ApiResponse<List<String>> response = responseFactory.createErrorResponse(
            Messages.Errors.VALIDATION_ERROR,
            ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getField)
                .toList()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
