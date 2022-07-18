package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;


    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }


    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        Post pulledPost = postsDao.getOne(id);
        model.addAttribute("post", pulledPost);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showPostForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = usersDao.getOne(1L);
        post.setAuthor(user);
        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Post post) {
        //TODO: Change user to logged in user dynamic
        User user = usersDao.getOne(1L);
        post.setAuthor(user);
        postsDao.save(post);
        return "redirect:/posts";
    }

    @GetMapping("posts/{id}/delete")
    public String delete(@PathVariable long id) {

        postsDao.deleteById(id);
        return "redirect:/posts";
    }

}




