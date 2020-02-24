package com.example.codeclan.CheckMate.models;

import com.example.codeclan.CheckMate.models.enums.CheckAsk;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="checksSent")
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="author_id")
    private Long author_id;

    @Column(name="recipient_id")
    private Long recipient_id;

    @Column(name = "initialCheck")
    private String initialCheck;

    @Column(name = "timestamp")
    private Long timestamp;

    public Check(User author, User recipient, CheckAsk initialCheck) {
        this.author_id = author.getId();
        this.recipient_id = recipient.getId();
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
        return this.author_id;
    }

    public void setAuthor(User author) {
        this.author_id = author.getId();
    }

    public Long getRecipient() {
        return this.recipient_id;
    }

    public void setRecipient(User recipient) {
        this.recipient_id = recipient.getId();
    }

    public String getInitialCheck() {
        return this.initialCheck;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }
}
