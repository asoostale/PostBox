package com.postbox.domain.post.reply;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyDto {

    private String contents;

    private LocalDateTime writeAt;

    private String username;

    public ReplyDto(String contents, LocalDateTime writeAt, String username) {
        this.contents = contents;
        this.writeAt = writeAt;
        this.username = username;
    }
}
