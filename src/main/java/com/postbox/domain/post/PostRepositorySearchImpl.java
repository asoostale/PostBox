package com.postbox.domain.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import static com.postbox.domain.post.QPost.post;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PostRepositorySearchImpl implements PostRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Post> searchByTitle(String title) {
        return queryFactory
                .selectFrom(post)
                .where(post.title.contains(title))
                .fetch();
    }

    @Override
    public List<Post> searchByContents(String contents) {
        return queryFactory
                .selectFrom(post)
                .where(post.contents.contains(contents))
                .fetch();
    }

    @Override
    public List<Post> searchByTitleWithContents(String title, String contents) {
        return queryFactory
                .selectFrom(post)
                .where(post.title.contains(title).and(post.contents.contains(contents)))
                .fetch();
    }
}
