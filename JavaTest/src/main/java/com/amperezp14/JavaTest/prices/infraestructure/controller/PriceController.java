package com.amperezp14.JavaTest.prices.infraestructure.controller;

import com.amperezp14.JavaTest.prices.application.IFindPriceUseCase;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceRequest;
import com.amperezp14.JavaTest.prices.infraestructure.rest.PriceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

@RestController
public class PriceController {

    @Autowired
    private IFindPriceUseCase findPriceUseCase;

    @PostMapping("/prices")
    public PriceResponse getPrice(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) PriceRequest data) {
        return findPriceUseCase.findPrice(data);
    }

}
