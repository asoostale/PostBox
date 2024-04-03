package com.postbox.domain.post.reply;

import com.postbox.domain.post.Post;
import com.postbox.domain.post.PostRepository;
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
public class ReplyService {

    private final ReplyRepository replyRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveReply(ReplyForm replyForm, Long id){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User findUser = userRepository.findByUsername(username);
        Post findPost = postRepository.findById(id).get();
        Reply reply = new Reply();
        reply.setContents(replyForm.getContents());
        reply.setUser(findUser);
        reply.setWriteAt(LocalDateTime.now());
        reply.setPost(findPost);

        replyRepository.save(reply);
    }

}
