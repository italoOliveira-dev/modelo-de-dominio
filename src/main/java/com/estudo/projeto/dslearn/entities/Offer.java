package com.estudo.projeto.dslearn.entities;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String edition;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant startMoment;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant endMoment;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(mappedBy = "offer")
    private List<Resource> resources;

    @OneToMany(mappedBy = "offer")
    private List<Topic> topics = new ArrayList<>();

    public Offer() {}

    public Offer(Course course, String edition, Instant endMoment, long id, List<Resource> resources, Instant startMoment, List<Topic> topics) {
        this.course = course;
        this.edition = edition;
        this.endMoment = endMoment;
        this.id = id;
        this.resources = resources;
        this.startMoment = startMoment;
        this.topics = topics;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public Instant getEndMoment() {
        return endMoment;
    }

    public void setEndMoment(Instant endMoment) {
        this.endMoment = endMoment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }

    public Instant getStartMoment() {
        return startMoment;
    }

    public void setStartMoment(Instant startMoment) {
        this.startMoment = startMoment;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
