package com.example.blog.controller;

import com.example.blog.entity.Comment;
import com.example.blog.payload.request.CreateCommentRequest;
import com.example.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/post/{postId}/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/create")
    public ResponseEntity<?> createComment(@Valid @RequestBody CreateCommentRequest request,@PathVariable long postId){
        Comment comment = commentService.saveComment(request, postId);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable long id){
        commentService.deleteCommentById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
