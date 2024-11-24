package com.example.doctorAppointment.controller;
import com.example.doctorAppointment.model.Post;
import com.example.doctorAppointment.service.impl.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:3000") // Adjust this to match your frontend origin
public class PostController {

    @Autowired
    private PostService postService;

    // Create a new post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    // Get all posts
    @GetMapping
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }
}
