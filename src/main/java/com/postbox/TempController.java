package com.postbox;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {

    @GetMapping("/")
    public String mainForm() {
        return "ui/ui-page";
    }



    @GetMapping("/login")
    public String loginForm() {
        return "/service/login";
    }

    @GetMapping("/join")
    public String joinForm() {
        return "/service/join";
    }

    @GetMapping("/mypage")
    public String mypage() {
        return "/user/mypage";
    }
}
