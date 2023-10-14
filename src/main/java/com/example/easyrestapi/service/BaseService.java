package com.example.easyrestapi.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface BaseService {
    ResponseEntity<Object> getOccurrences(String input);
    ResponseEntity<Object> getOccurrencesWithoutSpaces(String input);
}
