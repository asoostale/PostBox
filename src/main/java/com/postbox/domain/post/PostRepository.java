package com.postbox.domain.post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long>, PostRepositoryCustom {


    @Query("SELECT p FROM Post p WHERE p.categoryTest = '자유' ORDER BY p.id DESC")
    List<Post> findAllFree();

    @Query("SELECT p FROM Post p WHERE p.categoryTest = '질문' ORDER BY p.id DESC")
    List<Post> findAllQuest();

    @Query("SELECT p FROM Post p WHERE p.categoryTest = '공지사항' ORDER BY p.id DESC")
    List<Post> findAllAnnounce();

    @Query("SELECT p FROM Post p WHERE p.categoryTest = '추천' ORDER BY p.id DESC")
    List<Post> findAllRecommend();

    @Query("select p from Post p join fetch p.user where p.categoryTest = '자유'")
    List<Post> findPostWithViewCountAndUserFree();

    @Query("select p from Post p join fetch p.user where p.categoryTest = '추천'")
    List<Post> findPostWithViewCountAndUserFeature();

    @Query("select p from Post p join fetch p.user where p.categoryTest = '공지사항'")
    List<Post> findPostWithViewCountAndUserAnnounce();

    @Query("select p from Post p join fetch p.user where p.categoryTest = '질문'")
    List<Post> findPostWithViewCountAndUserQuestion();
}
