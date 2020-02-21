package com.example.codeclan.CheckMate.models;

import com.example.codeclan.CheckMate.models.enums.Mood;
import com.example.codeclan.CheckMate.models.enums.Tag;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="profile_picture")
    private String profilePicture;

    // Change String to Mood once enums available
    @Column(name="mood")
    private String mood;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    @JsonIgnoreProperties(value="users")
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name="users_groups",
            joinColumns = {@JoinColumn(name="user_id", nullable=false, updatable=false)},
            inverseJoinColumns = {@JoinColumn(name="group_id", nullable=false, updatable=false)})
    private List<Group> groups;

    @Column(name="tags")
    private List<Tag> tags;

    // Change String mood to Mood mood once Enums available
    public User(String name, String username, String password, String profilePicture, String mood) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.mood = mood;
        this.comments = new ArrayList<>();
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    // Change String to Mood once enums available
    public String getMood() {
        return mood;
    }

    // Change String to Mood once enums available
    public void setMood(String mood) {
        this.mood = mood;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
