package com.postbox;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String cssForm() {
        return "index";
    }

    @GetMapping("/test")
    public String testform() {
        return "test";
    }

    @GetMapping("/join")
    public String joinForm() {
        return "join";
    }
}
