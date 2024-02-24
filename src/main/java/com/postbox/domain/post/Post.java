package com.postbox.domain.post;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;
    private String title;
    private String contents;
    private int recommendation;
    private int unRecommendation;
    private LocalDateTime writeAt;
    private LocalDateTime modifiedAt;
    private int viewCount;

}
