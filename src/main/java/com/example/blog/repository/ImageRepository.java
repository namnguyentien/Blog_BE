package com.example.blog.repository;

import com.example.blog.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    
    @Query(nativeQuery = true, value = "SELECT * FROM image WHERE uploaded_by = ?1")
    public List<Image> getListImageOfUser(long userId);

    public Image findByLink(String link);

}
