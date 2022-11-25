package com.example.pttk_dbclpm;

import java.util.List;

public class Response<T> {
    public boolean success;
    public String message;
    public List<T> data;

    public Response(boolean success, String message, List<T> data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }
}
