package com.postbox.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {


    @Query("SELECT p FROM Post p WHERE p.categoryTest = '자유' ORDER BY p.id DESC")
    List<Post> findAllFree();

    @Query("SELECT p FROM Post p WHERE p.categoryTest = '질문' ORDER BY p.id DESC")
    List<Post> findAllQuest();

    @Query("SELECT p FROM Post p WHERE p.categoryTest = '공지사항' ORDER BY p.id DESC")
    List<Post> findAllAnnounce();

    @Query("SELECT p FROM Post p WHERE p.categoryTest = '추천' ORDER BY p.id DESC")
    List<Post> findAllRecommend();

}
