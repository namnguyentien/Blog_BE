package com.example.blog.service;

import com.example.blog.entity.Comment;
import com.example.blog.payload.request.CreateCommentRequest;

import java.util.List;

public interface CommentService {
    
    List<Comment> getAll();

    Comment getComment(long id, long postId);

    Comment saveComment(CreateCommentRequest request,long postId);

    Comment updateComment(long id, CreateCommentRequest request);

    void deleteCommentById(long id);
}
