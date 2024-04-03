package com.postbox.domain.post.reply;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    @PostMapping("/post/{id}/reply")
    public String saveReply(@PathVariable("id") Long id, @ModelAttribute ReplyForm replyForm) {
        replyService.saveReply(replyForm, id);
        return "redirect:/post/" + id; // 리다이렉션 경로를 동적으로 생성
    }

}
