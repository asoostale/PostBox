package com.postbox.domain.post;

import com.postbox.domain.post.reply.Reply;
import com.postbox.domain.user.User;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    private String title;

    @Lob
    private String contents;
    private int recommendation;
    private int unRecommendation;
    private LocalDateTime writeAt;
    private LocalDateTime modifiedAt;
    private int viewCount;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void setUser(User user) {
        this.user = user;
        user.getPosts().add(this);
    }

    @OneToMany(mappedBy = "post")
    List<Reply> replies = new ArrayList<>();

}
