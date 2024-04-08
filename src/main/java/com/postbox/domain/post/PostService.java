package com.postbox.domain.post;

import com.postbox.domain.user.User;
import com.postbox.domain.user.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
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

    @Transactional
    public void editPost(PostDto postDto, String username) {
        // findById 메서드를 사용하여 데이터베이스에서 기존 Post 엔티티 조회
        Post post = postRepository.findById(postDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Post not found with id " + postDto.getId()));

        // Post 엔티티의 속성을 PostDto로부터 받은 새 값으로 업데이트
        post.setTitle(postDto.getTitle());
        post.setContents(postDto.getContent());
        post.setModifiedAt(LocalDateTime.now()); // 수정 시간을 현재 시간으로 설정하는 것이 일반적인 경우에 해당
        post.setCategoryTest(postDto.getCategoryTest());

        // 여기서 save 호출은 필수가 아님. @Transactional 덕분에 변경 감지(dirty checking)가 일어나 업데이트가 자동으로 반영됨.
        // 하지만, save를 호출해도 문제는 없으며, 명시적으로 호출하는 것이 더 직관적일 수 있음.
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

    public List<PostDto> findAllPostWithUserAndViewCountFree() {
        return postRepository.findPostWithViewCountAndUserFree().stream()
                .map(p -> new PostDto(p.getId(), p.getUser().getUsername(), p.getTitle(), p.getContents(), p.getWriteAt(), p.getCategoryTest(), p.getViewCount()))
                .collect(Collectors.toList());
    }
    public List<PostDto> findAllPostWithUserAndViewCountAnnounce() {
        return postRepository.findPostWithViewCountAndUserAnnounce().stream()
                .map(p -> new PostDto(p.getId(), p.getUser().getUsername(), p.getTitle(), p.getContents(), p.getWriteAt(), p.getCategoryTest(), p.getViewCount()))
                .collect(Collectors.toList());
    }public List<PostDto> findAllPostWithUserAndViewCountFeat() {
        return postRepository.findPostWithViewCountAndUserFeature().stream()
                .map(p -> new PostDto(p.getId(), p.getUser().getUsername(), p.getTitle(), p.getContents(), p.getWriteAt(), p.getCategoryTest(), p.getViewCount()))
                .collect(Collectors.toList());
    }

    public List<PostDto> findAllPostWithUserAndViewCountQuestion() {
        return postRepository.findPostWithViewCountAndUserQuestion().stream()
                .map(p -> new PostDto(p.getId(), p.getUser().getUsername(), p.getTitle(), p.getContents(), p.getWriteAt(), p.getCategoryTest(), p.getViewCount()))
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

    @Transactional
    public Post updateViewCount(Long id) {
        Post post = postRepository.findById(id).get();
        post.updateHits();
        return post;
    }


    //    public Post updatePost(PostEditForm postEditForm) {
    //        Post post = postRepository.findById(postEditForm.getId()).get();
    //        post.edit(postEditForm);
    //      return   postRepository.save(post);
    //
    //    }
}
