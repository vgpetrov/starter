package com.vp.starter.controller;

import com.vp.starter.entities.JDate;
import com.vp.starter.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    DateService dateService;

    @GetMapping("/tz")
    public String hello() {
        return "Hello world " + dateService.getTZ();
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<JDate> getDate() {
        return dateService.getJdate();
    }

}
