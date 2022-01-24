package com.amperezp14.JavaTest.prices.infraestructure.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


@AutoConfigureMockMvc
@SpringBootTest
class PriceControllerTest {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private MockMvc mvc;


    @Test
    void getPrice() {
        try {
            RequestBuilder request = post("/prices");
            MvcResult result = mvc.perform(request).andReturn();
            assertEquals("", result.getResponse().getContentAsString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}