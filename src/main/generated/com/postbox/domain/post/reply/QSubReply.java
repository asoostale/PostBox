package com.postbox.domain.post.reply;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubReply is a Querydsl query type for SubReply
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubReply extends EntityPathBase<SubReply> {

    private static final long serialVersionUID = 1742564418L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubReply subReply = new QSubReply("subReply");

    public final StringPath contents = createString("contents");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QReply reply;

    public final com.postbox.domain.user.QUser user;

    public final DateTimePath<java.time.LocalDateTime> writeAt = createDateTime("writeAt", java.time.LocalDateTime.class);

    public QSubReply(String variable) {
        this(SubReply.class, forVariable(variable), INITS);
    }

    public QSubReply(Path<? extends SubReply> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubReply(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubReply(PathMetadata metadata, PathInits inits) {
        this(SubReply.class, metadata, inits);
    }

    public QSubReply(Class<? extends SubReply> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.reply = inits.isInitialized("reply") ? new QReply(forProperty("reply"), inits.get("reply")) : null;
        this.user = inits.isInitialized("user") ? new com.postbox.domain.user.QUser(forProperty("user")) : null;
    }

}

