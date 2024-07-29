package com.example.blog.service;

import com.example.blog.entity.Post;
import com.example.blog.payload.request.CreatePostRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    
    List<Post> getListPost();

    Page<Post> getPagePost(Integer pageNo,Integer pageSize,String sortBy);

    List<Post> getListPostByUser(long id);

    Post createPost(CreatePostRequest request);

    Post updatePost(long id,CreatePostRequest request);

    Post findPostById(long id);
    
    void deletePostById(long id);

}
