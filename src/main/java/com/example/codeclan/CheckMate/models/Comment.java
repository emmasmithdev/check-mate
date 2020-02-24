package com.example.codeclan.CheckMate.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id")
    private Long user_id;

    @Column(name="content")
    private String content;

    @JsonIgnoreProperties(value = "user")
    @ManyToOne
    @JoinColumn(name="post_id", nullable = false)
    private Post post;

    public Comment(User user, String content, Post post) {
        this.user_id = user.getId();
        this.content = content;
        this.post = post;
    }

    public Comment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user_id;
    }

    public void setUser(User user) {
        this.user_id = user.getId();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
