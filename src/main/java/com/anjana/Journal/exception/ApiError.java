package com.anjana.Journal.exception;

public class ApiError {
    private String message;
    private Object details;
    private int status;

    public ApiError(String message, Object details, int status){
        this.message = message;
        this.details = details;
        this.status = status;
    };

    public String getMessage(){
        return message;
    }

    public Object getDetails(){
        return details;
    }

    public int getStatus(){
        return status;
    }
}
