package com.example.blog.service;

import com.example.blog.entity.Image;

import java.util.List;

public interface ImageService {

    List<Image> getList();

    Image getImageById(long id);

    public void save(Image image);

    public List<Image> getListImageOfUser(long userId);

    public void deleteImage(String uploadDir,String fileName);
}
