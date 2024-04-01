package com.postbox.domain.post;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime writeAt;

    public PostDto(Long id, String title, String content, LocalDateTime writeAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writeAt = writeAt;
    }
}
