package com.postbox.domain.post;

import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime writeAt;
    private CategoryTest categoryTest;

    private String username;

    public PostDto() {
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
}
