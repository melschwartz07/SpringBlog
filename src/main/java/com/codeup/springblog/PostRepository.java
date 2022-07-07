package com.codeup.springblog;

import com.codeup.springblog.controllers.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
