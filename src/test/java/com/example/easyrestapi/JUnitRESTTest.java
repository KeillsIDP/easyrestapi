package com.example.easyrestapi;

import com.example.easyrestapi.controller.BaseController;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JUnitRESTTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BaseController controller;

    @Test
    public void inputRequired() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void inputWithSpaces() throws Exception {

        String input = "a b c";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/"+input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();


        LinkedHashMap<String,Integer> expectedResult = new LinkedHashMap<String,Integer>();
        expectedResult.put(" ",2);
        expectedResult.put("a",1);
        expectedResult.put("b",1);
        expectedResult.put("c",1);

        LinkedHashMap<String,Integer> data = JsonPath.read(result.getResponse().getContentAsString(), "$.data");

        assertEquals(expectedResult,data);

    }

    @Test
    public void inputWithoutSpaces() throws Exception {
        String input = "a b c";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .get("/ns/"+input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();


        LinkedHashMap<String,Integer> expectedResult = new LinkedHashMap<String,Integer>();
        expectedResult.put("a",1);
        expectedResult.put("b",1);
        expectedResult.put("c",1);

        LinkedHashMap<String,Integer> data = JsonPath.read(result.getResponse().getContentAsString(), "$.data");

        assertEquals(expectedResult,data);
    }
}
