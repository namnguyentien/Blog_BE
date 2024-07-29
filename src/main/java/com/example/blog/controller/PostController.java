package com.example.blog.controller;

import com.example.blog.entity.Post;
import com.example.blog.payload.request.CreatePostRequest;
import com.example.blog.service.ImageService;
import com.example.blog.service.PostService;
import com.example.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    
    @Autowired
    private PostService postService;

    @Autowired
    private ImageService imageService;

    @Autowired UserService userService;


    @GetMapping("/")
    public ResponseEntity<?> getListPost(){
        List<Post> listPost = postService.getListPost();
        return ResponseEntity.ok(listPost);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPost(@PathVariable long id){
        Post post = postService.findPostById(id);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getListPostByUser(@PathVariable long id){
        List<Post> listPost = postService.getListPostByUser(id);
        return ResponseEntity.ok(listPost);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@Valid @RequestBody CreatePostRequest request){
        Post post = postService.createPost(request);
        return ResponseEntity.ok(post);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable long id, @Valid @RequestBody CreatePostRequest request){
        Post post = postService.updatePost(id, request);
        return ResponseEntity.ok(post);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable long id){
        postService.deletePostById(id);

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
