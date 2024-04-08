package com.postbox.domain.message;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMessage is a Querydsl query type for Message
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMessage extends EntityPathBase<Message> {

    private static final long serialVersionUID = -1656836602L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMessage message = new QMessage("message");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> openStatus = createNumber("openStatus", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> receivedAt = createDateTime("receivedAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> sendAt = createDateTime("sendAt", java.time.LocalDateTime.class);

    public final StringPath title = createString("title");

    public final com.postbox.domain.user.QUser user;

    public QMessage(String variable) {
        this(Message.class, forVariable(variable), INITS);
    }

    public QMessage(Path<? extends Message> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMessage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMessage(PathMetadata metadata, PathInits inits) {
        this(Message.class, metadata, inits);
    }

    public QMessage(Class<? extends Message> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.postbox.domain.user.QUser(forProperty("user")) : null;
    }

}

