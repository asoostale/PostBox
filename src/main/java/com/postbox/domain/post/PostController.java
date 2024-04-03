package com.postbox.domain.post;

import com.postbox.domain.post.reply.Reply;
import com.postbox.domain.post.reply.ReplyForm;
import com.postbox.domain.post.reply.ReplyRepository;
import com.postbox.domain.post.reply.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    private final ReplyService replyService;
    private final ReplyRepository replyRepository;


    @GetMapping("/board-free")
    public String freeBoardPage(Model model) {
        List<PostDto> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "/post/free-board";
    }

    @GetMapping("/board-featured")
    public String featuredBoardPage(Model model) {
        List<PostDto> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "/post/featured-board";
    }

    @GetMapping("/board-quest")
    public String questBoardPage(Model model) {
        List<PostDto> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "/post/quest-board";
    }

    @GetMapping("/board-announce")
    public String announceBoardPage(Model model) {
        List<PostDto> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "/post/announce-board";
    }

    @GetMapping("/board-write")
    public String writePage(Model model) {
        model.addAttribute("postForm", new PostForm());
        return "/post/detail/write";
    }

    @PostMapping("/board-write")
    public String doPost(PostForm postForm) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        postService.savePost(postForm, username);

        return "redirect:/";

    }

    @GetMapping("/post/{id}")
    public String postDetailPage(Model model, @PathVariable("id") Long id) {
        PostDto findPost = postService.findById(id);
        List<Reply> replies = replyService.allComments();
        long totalCount = replyRepository.totalCount(id);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("replies", replies);
        model.addAttribute("post", findPost);
        model.addAttribute("replyForm", new ReplyForm());
        return "/post/detail/post-detail";
    }
}
