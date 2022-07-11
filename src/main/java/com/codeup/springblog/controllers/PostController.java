package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class PostController {

    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        ArrayList<Post> allPosts = new ArrayList<>();
        allPosts.add(new Post("title", "body"));
        allPosts.add(new Post("another title", "another body"));

        model.addAttribute("allPosts", allPosts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postView(@PathVariable long id, Model model){

        model.addAttribute("singlePost", new Post("title", "body"));
        return "posts/show";
    }

    @GetMapping("/posts/create/")
    public String postCreate(Model model){
        model.addAttribute("newPost", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String submitPost() { return "create a new post"; }

}