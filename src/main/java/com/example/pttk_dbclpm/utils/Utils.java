package com.example.pttk_dbclpm.utils;

import com.example.pttk_dbclpm.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class Utils {
    public static void responseClient(Response res, HttpServletResponse response) throws JsonProcessingException, IOException {
        ObjectMapper Obj = new ObjectMapper();
        String jsonStr = Obj.writeValueAsString(res);
        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.write(jsonStr);
        out.flush();
    }
}
