package com.postbox.domain.post.reply;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class SubReply {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_reply_id")
    private Long id;
    private String contents;
    private LocalDateTime writeAt;
}
