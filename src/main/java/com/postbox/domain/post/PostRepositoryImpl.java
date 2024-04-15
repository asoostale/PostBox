package com.postbox.domain.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.postbox.domain.post.QPost.post;

@Repository
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Autowired
    public PostRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Post> searchByTitle(String title) {
        return queryFactory
                .selectFrom(post)
                .where(post.title.contains(title))
                .fetch();
    }

    @Override
    public List<Post> searchByContent(String content) {
        return queryFactory
                .selectFrom(post)
                .where(post.contents.contains(content))
                .fetch();
    }

    @Override
    public List<Post> searchByTitleAndContent(String title, String content) {
        return queryFactory
                .selectFrom(post)
                .where(post.title.contains(title).or(post.contents.contains(content)))
                .fetch();
    }
}
