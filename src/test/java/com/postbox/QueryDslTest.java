package com.postbox;

import com.postbox.domain.user.QUser;
import com.postbox.domain.user.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class QueryDslTest {

    @Autowired
    EntityManager em;

    @Test
    public void queryDsTestUser() {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QUser m = new QUser("m");
        User findUser = queryFactory
                .select(m)
                .from(m)
                .where(m.username.eq("test"))
                .fetchOne();

        Assertions.assertThat(findUser.getUsername()).isEqualTo("test");

    }
}
