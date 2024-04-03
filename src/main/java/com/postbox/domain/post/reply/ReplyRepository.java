package com.postbox.domain.post.reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Query("SELECT COUNT(r) FROM Reply r WHERE r.post.id = :postId")
    long totalCount(@Param("postId") Long postId);



}
