package com.example.easyrestapi.service;

import com.example.easyrestapi.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

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
        // base map
        Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        // add entries
        for (Character symbol: input.toCharArray()) {
            if(map.containsKey(symbol))
                map.put(symbol,map.get(symbol) + 1);
            else
                map.put(symbol,1);
        }
        // list for sort
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(map.entrySet());
        // sorting the list
        Collections.sort(entryList, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> entry1, Map.Entry<Character, Integer> entry2) {
                return entry2.getValue().compareTo(entry1.getValue());
            }
        });
        // put entries in new order in map
        LinkedHashMap<Character, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

//        json with map
//                "a":10,
//                "b":5
//        json with list
//                [
//                  {
//                      "a":10
//                  },
//                  {
//                      "b":5
//                  }
//                ]

        return sortedMap;
    }
}
