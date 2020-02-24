package com.example.codeclan.CheckMate.models;

import com.example.codeclan.CheckMate.models.enums.CheckAsk;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="checksSent")
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnoreProperties("comments")
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @JsonIgnoreProperties("comments")
    @ManyToOne
    @JoinColumn(name = "recipient_id", nullable = false)
    private User recipient;

    @Column(name = "initialCheck")
    private String initialCheck;

    @Column(name = "timestamp")
    private Long timestamp;

    public Check(User author, User recipient, CheckAsk initialCheck) {
        this.author = author;
        this.recipient = recipient;
        this.initialCheck = initialCheck.getCheck();
        this.timestamp = Instant.now().getEpochSecond();
    }

    public Check() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthor() {
        return this.author.getId();
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getRecipient() {
        return this.recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public String getInitialCheck() {
        return this.initialCheck;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }
}
