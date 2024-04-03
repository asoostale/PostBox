package com.postbox.domain.user;

import com.postbox.domain.message.Message;
import com.postbox.domain.post.Post;
import com.postbox.domain.post.reply.Reply;
import com.postbox.domain.post.reply.SubReply;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.*;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter @Setter
@NoArgsConstructor(access = PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String password;
    private String role;

    private String email;

    private Boolean keepLogin; //로그인 기능 유지


    /**
     * casecade 삭제한 이유 => casecade = All이 상대 엔터티와 라이프 사이클이 같으면 상관없지만
     * * 조금이라도 다른 엔터티와 연관이 되 있따면 사용 X
     * ex ) Reply 같은경우 User에도 되있고, Post에도 되 있음.
     */

    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Reply> replies = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Message> messages = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<SubReply> subReplies = new ArrayList<>();






    /**
     * 1. 연관관계 메서드
     * 2. 비즈니스 로직 Domain model 패턴
     * 3. 생성메서드
     */


}
