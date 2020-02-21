package com.example.codeclan.CheckMate.models;

import com.example.codeclan.CheckMate.models.enums.Reaction;
import com.example.codeclan.CheckMate.models.enums.Tag;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user")
    private User user;

    @Column(name="content")
    private String content;

    @CreationTimestamp
    private LocalDateTime date;

    @Column(name="tags")
    private ArrayList<Tag> tags;

    @Column(name="reactions")
    private ArrayList<Reaction> reactions;

    @JsonIgnoreProperties(value="post")
    @OneToMany(mappedBy = "post_id", fetch = FetchType.LAZY)
    private ArrayList<Comment> comments;

    @JsonIgnoreProperties(value="posts")
    @ManyToOne
    @JoinColumn(name="group_id", nullable = false)
    private Group group;

    public Post(User user, String content,  Group group) {
        this.user = user;
        this.content = content;
        this.group = group;
        this.tags = new ArrayList<>();
        this.reactions = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Post() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public ArrayList<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(ArrayList<Reaction> reactions) {
        this.reactions = reactions;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void addTag(Tag tag){
        this.tags.add(tag);
    }

    public void addReaction(Reaction reaction){
        this.reactions.add(reaction);
    }
    public void addComment(Comment comment){
        this.comments.add(comment);
    }
}
