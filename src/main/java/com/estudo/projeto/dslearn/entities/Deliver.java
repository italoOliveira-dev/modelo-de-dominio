package com.estudo.projeto.dslearn.entities;

import com.estudo.projeto.dslearn.entities.enums.DeliverStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_deliver")
public class Deliver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uri;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime moment;
    private DeliverStatus status;
    private String feedback;
    private Integer correctCount;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "offer_id"),
            @JoinColumn(name = "user_id")
    })
    private Enrollment enrollment;

    @ManyToOne
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    public Deliver() {}

    public Deliver(Integer correctCount, Enrollment enrollment, String feedback, Long id, Lesson lesson, LocalDateTime moment, DeliverStatus status, String uri) {
        this.correctCount = correctCount;
        this.enrollment = enrollment;
        this.feedback = feedback;
        this.id = id;
        this.lesson = lesson;
        this.moment = moment;
        this.status = status;
        this.uri = uri;
    }

    public Integer getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(Integer correctCount) {
        this.correctCount = correctCount;
    }

    public Enrollment getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
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

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public DeliverStatus getStatus() {
        return status;
    }

    public void setStatus(DeliverStatus status) {
        this.status = status;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
