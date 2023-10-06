package com.example.easyrestapi.model;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ResponseBody
public class Number {
    private String input;
    private Map<Character,Integer> output;

    public Number(String input){
        this.input = input;
        this.output = defineOutput();
    }

    private Map<Character,Integer> defineOutput(){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for (Character symbol: this.input.toCharArray()) {
            if(map.containsKey(symbol))
                map.put(symbol,map.get(symbol) + 1);
            else
                map.put(symbol,1);
        }

        map.entrySet().stream().sorted(Map.Entry.comparingByValue());

        return map;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Map<Character, Integer> getOutput() {
        return output;
    }

    public void setOutput(Map<Character, Integer> output) {
        this.output = output;
    }
}
