package com.example.codeclan.CheckMate.models;

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

    @Column(name="post_id", nullable = false)
    private Long postId;

    public Comment(User user, String content, Long postId) {
        this.user_id = user.getId();
        this.content = content;
        this.postId = postId;
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

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
