package com.postbox.domain.user;

import com.postbox.domain.message.Message;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    private String username;
    private String password;
    private String role;
    private String email;

    private Boolean keepLogin; //로그인 기능 유지

    /*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL);
    @JoinColumn
    private List<Message> messages = new ArrayList<>();*/

}
