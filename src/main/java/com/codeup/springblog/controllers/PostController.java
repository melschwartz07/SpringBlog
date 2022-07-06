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

    // dependency injection
    //    instance field / instance property
    private final PostRepository postsDao;
    private final UserRepository usersDao;

    //constructor for the above
    public PostController(PostRepository postsDao, UserRepository usersDao) {
        this.postsDao = postsDao;
        this.usersDao = usersDao;
    }

    //all posts
    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }

    //    show a post by it's ID
    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        Post pulledPost = postsDao.getOne(id);
        model.addAttribute("post", pulledPost);
        return "posts/show";
    }

    // ********** without form model binding --- notice that the method names are different between the examples
//    @GetMapping("/posts/create")
//    public String create(){
//        return "posts/create";
//    }
//
//    @PostMapping("/posts/create")
//    public String insert(@RequestParam String title, @RequestParam String body){
//        User user = usersDao.getOne(1L);
//        Post post = new Post(title, body, user);
//        post.setAuthor(user);
//        postsDao.save(post);
//        return "redirect:/posts";
//    }

    //this gets the create info from this url pattern
    @GetMapping("/posts/create")
    public String showPostForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    // returns the saved post object and posts it to view all posts
    @PostMapping("posts/create")
    public String createPost(@ModelAttribute Post post) {
        User user = usersDao.getOne(1L);
        post.setAuthor(user);
        postsDao.save(post);
        return "redirect:/posts";
    }


// ********** without form model binding
//    @GetMapping("/posts/{id}/edit")
//    public String editForm(@PathVariable long id, Model model) {
//        model.addAttribute("post", postsDao.getOne(id));
//        return "posts/edit";
//    }
//
//    @PostMapping("/posts/{id}/edit")
//    public String update(@PathVariable long id,
//                         @RequestParam String title,
//                         @RequestParam String body) {
//        // update our database with the latest title and body form the edit form
//        // get the post from the db to edit
//        Post postToEdit = postsDao.getOne(id);
//
//        // set the postToEdit title and body with values/parameters from the request
//        postToEdit.setTitle(title);
//        postToEdit.setBody(body);
//
//        // save the changes in the database
//        postsDao.save(postToEdit);
//
//        // redirect show page for the given post
//        return "redirect:/posts/" + id;
//    }

    //    ********** with form model binding ****** //
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
//        Post deletedPost = postsDao.getOne(id);
        postsDao.deleteById(id);
        return "redirect:/posts";
    }

}


