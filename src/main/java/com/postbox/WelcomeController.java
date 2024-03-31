package com.postbox;

import com.postbox.domain.post.PostDto;
import com.postbox.domain.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WelcomeController {
    private final PostService postService;

    @GetMapping("/")
    public String home(Model model) {
        List<PostDto> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "ui/ui-page";
    }
}
