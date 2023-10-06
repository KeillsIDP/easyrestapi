package com.example.easyrestapi.controller;

import com.example.easyrestapi.model.Number;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numbers")
public class NumberController {

    @GetMapping
    public ResponseEntity getOccurances(@RequestParam String input){
        try{
            return ResponseEntity.ok().body(new Number(input));
        }
        catch(Exception e){
            return ResponseEntity.badRequest().body("Error");
        }
    }

}
