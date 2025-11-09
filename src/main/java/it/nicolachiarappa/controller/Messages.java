package it.nicolachiarappa.controller;

public interface Messages {

    interface Errors{
        String VALIDATION_ERROR = "Validation error occurred";
        String DATABASE_ERROR = "Database error occurred";
    }

    interface Success{
        String ACCOUNT_FOUND = "Account data retrieved";
        String ACCOUNT_MODIFIED = "Account modified successfully";
        String ACCOUNT_CREATED = "Account created successfully";
    }



}
