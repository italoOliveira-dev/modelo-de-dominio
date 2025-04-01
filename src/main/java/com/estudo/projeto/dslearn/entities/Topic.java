package com.estudo.projeto.dslearn.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_topic")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String body;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime moment;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    private Offer offer;

    @ManyToMany
    @JoinTable(
            name = "tb_topic_likes",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> likes = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Reply answer;

    @OneToMany(mappedBy = "topic")
    private List<Reply> replies = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    public Topic() {}

    public Topic(Reply answer, User author, String body, Long id, Lesson lesson, Set<User> likes, LocalDateTime moment, Offer offer, List<Reply> replies, String title) {
        this.answer = answer;
        this.author = author;
        this.body = body;
        this.id = id;
        this.lesson = lesson;
        this.likes = likes;
        this.moment = moment;
        this.offer = offer;
        this.replies = replies;
        this.title = title;
    }

    public Reply getAnswer() {
        return answer;
    }

    public void setAnswer(Reply answer) {
        this.answer = answer;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
