package com.example.codeclan.CheckMate.models;

import com.example.codeclan.CheckMate.models.enums.Reaction;
import com.example.codeclan.CheckMate.models.enums.Tag;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id")
    private Long user_id;

    @Column(name="content")
    private String content;

    @CreationTimestamp
    private LocalDateTime date;

    @Column(name="tags")
    private ArrayList<Tag> tags;

    @ElementCollection(targetClass = Reaction.class)
    @CollectionTable(name = "post_reactions", joinColumns = @JoinColumn(name = "post_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "reaction_id")
    private List<Reaction> reactions;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="group_id", nullable = false)
    private Group group;

    public Post(User user, String content,  Group group) {
        this.user_id = user.getId();
        this.content = content;
        this.group = group;
        this.tags = new ArrayList<>();
        this.reactions = new ArrayList<>();
    }

    public Post() {
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(ArrayList<Reaction> reactions) {
        this.reactions = reactions;
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

}
