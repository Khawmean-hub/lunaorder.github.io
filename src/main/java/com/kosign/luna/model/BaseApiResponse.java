package com.kosign.luna.model;

public class BaseApiResponse {

    private String code;
    private String message;
    private Object data = new EmptyJsonBody();


    public BaseApiResponse() {
    }

    public BaseApiResponse(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BaseApiResponse code(String code) {
        setCode(code);
        return this;
    }

    public BaseApiResponse message(String message) {
        setMessage(message);
        return this;
    }

    public BaseApiResponse data(Object data) {
        setData(data);
        return this;
    }

}
