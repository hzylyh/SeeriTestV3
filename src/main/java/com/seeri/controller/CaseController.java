package com.seeri.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/case")
public class CaseController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAllCase() {
        return "Success";
    }


    @RequestMapping(value = "/run", method = RequestMethod.POST)
    public String runCase() {
        return "Success";
    }
}
