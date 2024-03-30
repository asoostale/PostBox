package com.postbox.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {

    @GetMapping("/")
    public String welcomePage() {
        return "ui/ui-page";
    }
}
