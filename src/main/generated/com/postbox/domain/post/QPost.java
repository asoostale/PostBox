package com.postbox.domain.post;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = -1431909676L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final EnumPath<CategoryTest> categoryTest = createEnum("categoryTest", CategoryTest.class);

    public final StringPath contents = createString("contents");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Integer> recommendation = createNumber("recommendation", Integer.class);

    public final ListPath<com.postbox.domain.post.reply.Reply, com.postbox.domain.post.reply.QReply> replies = this.<com.postbox.domain.post.reply.Reply, com.postbox.domain.post.reply.QReply>createList("replies", com.postbox.domain.post.reply.Reply.class, com.postbox.domain.post.reply.QReply.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final NumberPath<Integer> unRecommendation = createNumber("unRecommendation", Integer.class);

    public final com.postbox.domain.user.QUser user;

    public final NumberPath<Integer> viewCount = createNumber("viewCount", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> writeAt = createDateTime("writeAt", java.time.LocalDateTime.class);

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.postbox.domain.user.QUser(forProperty("user")) : null;
    }

}

