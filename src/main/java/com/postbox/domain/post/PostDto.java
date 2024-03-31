package com.postbox.domain.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {

    private String title;
    private String content;
    private LocalDateTime writeAt;

    public PostDto(String title, String content, LocalDateTime writeAt) {
        this.title = title;
        this.content = content;
        this.writeAt = writeAt;
    }
}
