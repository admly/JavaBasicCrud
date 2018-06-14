package com.studbaza.baza.controllers;

import com.studbaza.baza.model.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String greetingForm(Model model) {
        return "welcome";
    }

}
