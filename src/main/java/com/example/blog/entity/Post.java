package com.example.blog.entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String description;

    private String content;

    private int status;

    private Timestamp createAt;

    private Timestamp modifiedAt;

    private Timestamp publishedAt;

    @ManyToOne
    @JoinColumn(name = "create_by")
    public User createBy;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "post_image", joinColumns = @JoinColumn(name = "post_id")
    , inverseJoinColumns = @JoinColumn(name = "image_id"))
    private List<Image> images;

}

