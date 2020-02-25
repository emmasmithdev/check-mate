package com.example.codeclan.CheckMate.models;


import com.example.codeclan.CheckMate.models.enums.CheckAns;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name="received_checks")
public class ReceivedCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="author_id")
    private Long author_id;

    @Column(name="recipient_id")
    private Long recipient_id;

    @Column(name = "reply")
    private String reply;

    @Column(name = "timestamp")
    private Long timestamp;

    public ReceivedCheck(User author_id, User recipient_id, CheckAns reply) {
        this.author_id = author_id.getId();
        this.recipient_id = recipient_id.getId();
        this.reply = reply.getCheck();
        this.timestamp = Instant.now().getEpochSecond();
    }

    public ReceivedCheck() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(User author_id) {
        this.author_id = author_id.getId();
    }

    public Long getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(User recipient_id) {
        this.recipient_id = recipient_id.getId();
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
