package com.postbox.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1199771060L;

    public static final QUser user = new QUser("user");

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath keepLogin = createBoolean("keepLogin");

    public final ListPath<com.postbox.domain.message.Message, com.postbox.domain.message.QMessage> messages = this.<com.postbox.domain.message.Message, com.postbox.domain.message.QMessage>createList("messages", com.postbox.domain.message.Message.class, com.postbox.domain.message.QMessage.class, PathInits.DIRECT2);

    public final StringPath password = createString("password");

    public final ListPath<com.postbox.domain.post.Post, com.postbox.domain.post.QPost> posts = this.<com.postbox.domain.post.Post, com.postbox.domain.post.QPost>createList("posts", com.postbox.domain.post.Post.class, com.postbox.domain.post.QPost.class, PathInits.DIRECT2);

    public final ListPath<com.postbox.domain.post.reply.Reply, com.postbox.domain.post.reply.QReply> replies = this.<com.postbox.domain.post.reply.Reply, com.postbox.domain.post.reply.QReply>createList("replies", com.postbox.domain.post.reply.Reply.class, com.postbox.domain.post.reply.QReply.class, PathInits.DIRECT2);

    public final StringPath role = createString("role");

    public final ListPath<com.postbox.domain.post.reply.SubReply, com.postbox.domain.post.reply.QSubReply> subReplies = this.<com.postbox.domain.post.reply.SubReply, com.postbox.domain.post.reply.QSubReply>createList("subReplies", com.postbox.domain.post.reply.SubReply.class, com.postbox.domain.post.reply.QSubReply.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

