package com.example.NetConnect.utils;

import org.springframework.http.HttpStatus;

import java.util.Collection;

public class CommonResponseObject {
    private String message;
    private Collection<?> data;
    private boolean success;
    private HttpStatus httpStatus;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Collection<?> getData() {
        return data;
    }

    public void setData(Collection<?> data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public static CommonResponseObject buildSuccessResponse(CommonResponseObject commonResponseObject, String message, Collection<?> data, HttpStatus status) {
        commonResponseObject.setMessage(message);
        commonResponseObject.setData(data);
        commonResponseObject.setSuccess(true);
        commonResponseObject.setHttpStatus(status);
        return commonResponseObject;
    }

    public static CommonResponseObject buildFailureResponse(CommonResponseObject commonResponseObject, String message, HttpStatus status) {
        commonResponseObject.setMessage(message);
        commonResponseObject.setSuccess(false);
        commonResponseObject.setHttpStatus(status);
        return commonResponseObject;
    }
}
