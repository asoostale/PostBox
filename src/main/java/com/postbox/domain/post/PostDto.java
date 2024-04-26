package com.postbox.domain.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class PostDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private LocalDateTime writeAt;
    private CategoryTest categoryTest;
    private int viewCount;


    public PostDto() {
    }

    public PostDto(Long id, String username, String title, String content, LocalDateTime writeAt, CategoryTest categoryTest, int viewCount, String username1) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.writeAt = writeAt;
        this.categoryTest = categoryTest;
        this.viewCount = viewCount;
        this.username = username1;
    }

    public PostDto(Long id, String title, String content, LocalDateTime writeAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writeAt = writeAt;
    }

    public PostDto(Long id, String title, String content, LocalDateTime writeAt, String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writeAt = writeAt;
        this.username = username;
    }

    public PostDto(Long id, String title, String content, LocalDateTime writeAt, CategoryTest categoryTest, int viewCount, String username) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writeAt = writeAt;
        this.categoryTest = categoryTest;
        this.viewCount = viewCount;
        this.username = username;
    }
}
