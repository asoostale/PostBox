package com.postbox.domain.user;

import com.postbox.domain.message.Message;
import com.postbox.domain.post.Post;
import com.postbox.domain.post.reply.Reply;
import com.postbox.domain.post.reply.SubReply;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String password;

    private String email;

    private Boolean keepLogin; //로그인 기능 유지


    @OneToMany(mappedBy = "user", cascade = ALL)
    private List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = ALL)
    private List<Reply> replies = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = ALL)
    private List<Message> messages = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = ALL)
    private List<SubReply> subReplies = new ArrayList<>();
    @OneToMany(mappedBy = "user", cascade = ALL)
    private List<Log> logs = new ArrayList<>();


    /**
     * 1. 연관관계 메서드
     * 2. 비즈니스 로직 Domain model 패턴
     * 3. 생성메서드
     */


}
