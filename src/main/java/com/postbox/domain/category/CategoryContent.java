package com.postbox.domain.category;


import com.postbox.domain.post.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class CategoryContent {

    /**
     * ManyToMany 를 피하기 위한 양방향 연관관계 대안으로서
     * 양쪽에서(Category, Content 클래스) oneToMany 를 구현.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_content_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;


}


