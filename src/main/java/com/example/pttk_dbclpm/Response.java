package com.example.pttk_dbclpm;


public class Response<T> {
    public boolean success;
    public String message;
    public T data;

    public Response(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
