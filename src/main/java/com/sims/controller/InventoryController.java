package com.sims.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InventoryController {
    @RequestMapping("/inventory")
    String index(){
        return "inventory";
    }
}
