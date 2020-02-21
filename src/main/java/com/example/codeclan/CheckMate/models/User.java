package com.example.codeclan.CheckMate.models;

import com.example.codeclan.CheckMate.models.enums.Mood;
import com.example.codeclan.CheckMate.models.enums.Tag;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;

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

    @Column(name="mood")
    private String mood;

    @JsonBackReference
    @ManyToMany
    @JoinColumn(name="groups")
    private ArrayList<Group> groups;

    @Column(name="tags")
    private ArrayList<Tag> tags;

    public User(String name, String username, String password, String profilePicture, String mood) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.profilePicture = profilePicture;
        this.mood = mood;
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

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

}
