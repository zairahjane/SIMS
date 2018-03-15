package com.sims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MonitoringController {
    @RequestMapping("swine/{swine}/monitoring")
    String index(){
        return "monitoring";
    }
}
