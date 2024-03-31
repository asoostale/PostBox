package com.postbox.domain.post;

import com.postbox.domain.user.User;
import com.postbox.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public void savePost(PostForm postForm, String username) {

        User user = userRepository.findByUsername(username);


        Post post = new Post();
        post.setTitle(postForm.getTitle());
        post.setContents(postForm.getContent());
        post.setWriteAt(LocalDateTime.now());
        post.setUser(user);
        postRepository.save(post);
    }


}
