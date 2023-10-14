package com.example.easyrestapi.service;

import com.example.easyrestapi.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class BaseServiceImpl implements BaseService{

    @Override
    public ResponseEntity<Object> getOccurrences(String input){
        try {
            return ResponseHandler.responseBuilder("Частота появления символов в строке " + input, HttpStatus.OK, getMap(input));
        }
        catch (Exception e){
            return ResponseHandler.responseBuilder("Ошибка", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    @Override
    public ResponseEntity<Object> getOccurrencesWithoutSpaces(String input){
        try {
            input = input.replace(" ","");
            return ResponseHandler.responseBuilder("Частота появления символов (без учета пробела) в строке "+input, HttpStatus.OK, getMap(input));
        }
        catch (Exception e){
            return ResponseHandler.responseBuilder("Ошибка", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }

    private Map<Character,Integer> getMap(String input){
        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for (Character symbol: input.toCharArray()) {
            if(map.containsKey(symbol))
                map.put(symbol,map.get(symbol) + 1);
            else
                map.put(symbol,1);
        }

        map.entrySet().stream().sorted(Map.Entry.comparingByValue());

        return map;
    }
}
