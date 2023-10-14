package com.example.easyrestapi.controller;

import com.example.easyrestapi.service.BaseService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class BaseController {

    @Autowired
    private BaseService service;

    @GetMapping("/{input}")
    public ResponseEntity getOccurrences(@PathVariable String input){
            return service.getOccurrences(input);
    }

    @GetMapping("/ns/{input}")
    public ResponseEntity getOccurrencesWithoutSpaces(@PathVariable String input){
        return service.getOccurrencesWithoutSpaces(input);
    }

}
