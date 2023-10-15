package com.example.easyrestapi.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

// simple response representation
public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseObject){
        Map<String,Object> response = new HashMap<String,Object>();
        response.put("data",responseObject);
        response.put("message",message);
        response.put("status",httpStatus);

        return new ResponseEntity<>(response,httpStatus);
    }
}
