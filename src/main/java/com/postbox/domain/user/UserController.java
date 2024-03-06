package com.postbox.domain.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String serviceMainForm() {
        return "fragment/bodyHeader";
    }

    @GetMapping("/join")
    public String joinForm() {
        return "service/join";

    }
}
