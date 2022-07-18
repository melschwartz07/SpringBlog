package com.codeup.springblog.repositories;


import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {


    Post findByTitle(String title);

    Post findFirstByOrderByTitleAsc();

    @Query("from Post p where p.id like ?1")
    Post getPostById(long id);

    @Query("select title from Post where LENGTH(title) < 10")
    List<String> getPostsOfCertainTitleLength();

    // using a native query
    @Query(nativeQuery = true, value = "SELECT title FROM posts WHERE LENGTH(title) < 10")
    List<String> getPostsOfCertainTitleLengthNative();


}