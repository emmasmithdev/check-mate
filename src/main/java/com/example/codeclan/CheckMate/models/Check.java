package com.example.codeclan.CheckMate.models;

import com.example.codeclan.CheckMate.models.enums.CheckAsk;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="checksSent")
public class Check {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "recipient_id", nullable = false)
    private User recipient;

    @Column(name = "initialCheck")
    private String initialCheck;

    @CreationTimestamp
    private Timestamp timestamp;

    public Check(User author, User recipient, CheckAsk initialCheck) {
        this.author = author;
        this.recipient = recipient;
        this.initialCheck = initialCheck.getCheck();
    }

    public Check() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return this.author;
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

    public void setInitialCheck(String initialCheck) {
        this.initialCheck = initialCheck;
    }

    public Long getTimestamp() {
        return this.timestamp.getTime();
    }


}
