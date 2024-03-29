package com.postbox.domain.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/join")
    public String joinPage(Model model) {
        model.addAttribute("userForm", new JoinForm());
        return "/service/join";
    }

    @PostMapping("/joinProc")
    public String saveUser(@Valid JoinForm joinForm, BindingResult result) {
        if (result.hasErrors()) {
            return "service/join";
        }
        joinService.save(joinForm);
        return "redirect:/https:www.google.com";
    }

}
