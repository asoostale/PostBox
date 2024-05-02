package com.postbox.domain.user;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryByJdbcTemplate {

    private final JdbcTemplate template;

    public MemberRepositoryByJdbcTemplate(JdbcTemplate template) {
        this.template = template;
    }

//    public User findUser(Long id) {
//        return template.queryForObject("select user_id name from user where user_io=?",
//                BeanPropertyRowMapper.newInstance(User.class), id);
//    }
}
