package com.postbox.domain.post.reply;

import com.postbox.domain.post.Post;
import com.postbox.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;
    private String contents;
    private LocalDateTime writeAt;
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    public void setUser(User user) {
        this.user = user;
        user.getReplies().add(this);
    }

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public void setPost(Post post) {
        this.post = post;
        post.getReplies().add(this);
    }


    @OneToMany(mappedBy = "reply", cascade = ALL)
    private List<SubReply> subReplies = new ArrayList<>();



}
