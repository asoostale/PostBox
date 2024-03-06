package com.postbox.domain.post.reply;

import com.postbox.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
public class SubReply {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_reply_id")
    private Long id;
    private String contents;
    private LocalDateTime writeAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
        user.getSubReplies().add(this);
    }

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "reply_id")
    private Reply reply;

    public void setUser(Reply reply) {
        this.reply = reply;
        reply.getSubReplies().add(this);
    }
}
