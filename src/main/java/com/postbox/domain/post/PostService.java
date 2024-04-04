package com.postbox.domain.post;

import com.postbox.domain.user.User;
import com.postbox.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        post.setCategoryTest(postForm.getCategoryTest());
        post.setUser(user);
        postRepository.save(post);
    }

    public List<PostDto> findAllPost() {
        return postRepository.findAll().stream()
                .map(p -> new PostDto(p.getId(), p.getTitle(), p.getContents(), p.getWriteAt()))
                .collect(Collectors.toList());
    }

    public List<PostDto> findAllPostFree() {
        return postRepository.findAllFree().stream()
                .map(p -> new PostDto(p.getId(), p.getTitle(), p.getContents(), p.getWriteAt()))
                .collect(Collectors.toList());
    }

    public List<PostDto> findAllPostAnnounce() {
        return postRepository.findAllAnnounce().stream()
                .map(p -> new PostDto(p.getId(), p.getTitle(), p.getContents(), p.getWriteAt()))
                .collect(Collectors.toList());
    }

    public List<PostDto> findAllPostQuest() {
        return postRepository.findAllQuest().stream()
                .map(p -> new PostDto(p.getId(), p.getTitle(), p.getContents(), p.getWriteAt()))
                .collect(Collectors.toList());
    }

    public List<PostDto> findAllPostRecommend() {
        return postRepository.findAllRecommend().stream()
                .map(p -> new PostDto(p.getId(), p.getTitle(), p.getContents(), p.getWriteAt()))
                .collect(Collectors.toList());
    }


    public PostDto findById(Long id) {

        Post post = postRepository.findById(id).get();
        PostDto postDto = new PostDto(post.getId(), post.getTitle(), post.getContents(), post.getWriteAt(), post.getUser().getUsername());
        return postDto;
    }

}
