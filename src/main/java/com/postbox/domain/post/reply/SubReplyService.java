package com.postbox.domain.post.reply;


import com.postbox.domain.user.User;
import com.postbox.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubReplyService {

    private final SubReplyRepository subReplyRepository;
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long saveSubReply(Long id, SubReplyDto subReplyDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userRepository.findByUsername(username);
        Reply reply = replyRepository.findById(id).orElseThrow(() -> new RuntimeException("Reply not found"));
        SubReply subReply = new SubReply();
        subReply.setReply(reply);
        subReply.setContents(subReplyDto.getContents());
        subReply.setWriteAt(LocalDateTime.now());
        subReply.setUser(user);
        subReplyRepository.save(subReply);
        // 원본 게시물 ID 반환
        return reply.getPost().getId();
    }

}
