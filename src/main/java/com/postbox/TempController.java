package com.postbox;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {

    @GetMapping("/ui")
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

    @GetMapping("/f-board")
    public String boardFeatured(){
        return "/post/featured-board";
    }

    //글 작성폼
    @GetMapping("/dopost")
    public String doPostForm() {
        return "/post/detail/post-write";
    }

}
