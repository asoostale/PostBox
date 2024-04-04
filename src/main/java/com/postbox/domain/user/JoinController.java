package com.postbox.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/join")
    public String joinPage(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        model.addAttribute("username", username);
        model.addAttribute("joinForm", new JoinForm());
        return "service/join";
    }

    @PostMapping("/joinProc")
    public String saveUser(JoinForm joinForm) {
        joinService.save(joinForm);
        return "redirect:/";
    }

}
