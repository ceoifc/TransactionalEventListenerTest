package com.example.demo2;

import org.springframework.web.bind.annotation.*;

@RestController
public class TempController {

    private final TempService service;

    public TempController(TempService service) {
        this.service = service;
    }

    @PostMapping("/test")
    public String temp(@RequestParam Long id) {
        service.saveTemp(id);
        return "ok " + id;
    }

    @GetMapping("/test/{id}")
    public String temp2(@PathVariable Long id) {
        service.getTemp(id);
        return "ok";
    }
}
