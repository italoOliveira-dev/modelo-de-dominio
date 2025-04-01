package com.estudo.projeto.dslearn.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer position;

    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;

    @ManyToMany
    @JoinTable(
            name = "tb_lessons_done",
            joinColumns = @JoinColumn(name = "lesson_id"),
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id"),
                    @JoinColumn(name = "offer_id")
            }
    )
    private final Set<Enrollment> enrollmentsDone = new HashSet<>();

    @OneToMany(mappedBy = "lesson")
    private List<Deliver> deliveries = new ArrayList<>();

    @OneToMany(mappedBy = "lesson")
    private List<Topic> topics = new ArrayList<>();

    public Lesson() {}

    public Lesson(Long id, Integer position, Section section, String title) {
        this.id = id;
        this.position = position;
        this.section = section;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Enrollment> getEnrollmentsDone() {
        return enrollmentsDone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Lesson lesson = (Lesson) o;
        return id.equals(lesson.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public List<Deliver> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(List<Deliver> deliveries) {
        this.deliveries = deliveries;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
