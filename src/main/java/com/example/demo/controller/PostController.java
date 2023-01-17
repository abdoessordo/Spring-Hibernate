package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.respo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostRepository postRpository;

    @Autowired
    public PostController(PostRepository postRpository) {
        this.postRpository = postRpository;
    }

    @GetMapping("/all")
    public List<Post> getAllPosts (){
        return postRpository.findAll();
    }
}
