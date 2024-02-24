package com.postbox.domain.post.reply;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Reply {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;
    private String contents;
    private LocalDateTime writeAt;
    private LocalDateTime modifiedAt;
}
