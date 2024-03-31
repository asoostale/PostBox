package com.postbox.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    @GetMapping("/board1")
    public String freeBoardPage() {
        return "/post/free-board";
    }

    @GetMapping("/board-write")
    public String writePage(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "/post/detail/write";
    }

    @PostMapping("/board-write")
    public String doPost(PostForm postForm) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        postService.savePost(postForm, username);

        return "redirect:/";

    }
}
