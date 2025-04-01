package com.estudo.projeto.dslearn.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name = "tb_task")
public class Task extends Lesson {

    private String description;
    private Integer questionCount;
    private Integer approvalCount;
    private Double weight;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant dueDate;

    public Task() {}

    public Task(Long id, Integer position, Section section, String title, Integer approvalCount, String description, Instant dueDate, Integer questionCount, Double weight) {
        super(id, position, section, title);
        this.approvalCount = approvalCount;
        this.description = description;
        this.dueDate = dueDate;
        this.questionCount = questionCount;
        this.weight = weight;
    }

    public Integer getApprovalCount() {
        return approvalCount;
    }

    public void setApprovalCount(Integer approvalCount) {
        this.approvalCount = approvalCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getDueDate() {
        return dueDate;
    }

    public void setDueDate(Instant dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(Integer questionCount) {
        this.questionCount = questionCount;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
