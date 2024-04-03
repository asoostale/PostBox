package com.postbox.domain.post.reply;

import com.postbox.domain.post.Post;
import com.postbox.domain.post.PostRepository;
import lombok.RequiredArgsConstructor;
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


    @Transactional
    public void saveReply(ReplyForm replyForm, Long id){
        Post findPost = postRepository.findById(id).get();
        Reply reply = new Reply();
        reply.setContents(replyForm.getContents());
        reply.setWriteAt(LocalDateTime.now());
        reply.setPost(findPost);

        replyRepository.save(reply);
    }

}
