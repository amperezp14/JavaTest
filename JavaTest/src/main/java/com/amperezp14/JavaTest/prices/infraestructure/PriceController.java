package com.amperezp14.JavaTest.prices.infraestructure;

import org.springframework.web.bind.annotation.*;

@RestController
public class PriceController {

    @GetMapping("/test")
    public String test() {
        return "OK";
    }

    @PostMapping("/prices")
    public String getPrice(@RequestBody String data) {

        return "OK Prices";
    }

}
