package com.Semi_Projrct.Ciyt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Scanner;

@Controller
public class HomeComtroller {

    @GetMapping("/")
    public String index() {
        return "index";
    }


}
