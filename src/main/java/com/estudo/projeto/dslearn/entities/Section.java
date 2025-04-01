package com.estudo.projeto.dslearn.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int position;
    private String imgUri;

    @ManyToOne
    @JoinColumn(name = "prerequisite_id")
    private Section prerequisite;

    @ManyToOne
    @JoinColumn(name = "resource_id")
    private Resource resource;

    public Section() {}

    public Section(String description, Long id, String imgUri, int position, Section prerequisite, Resource resource, String title) {
        this.description = description;
        this.id = id;
        this.imgUri = imgUri;
        this.position = position;
        this.prerequisite = prerequisite;
        this.resource = resource;
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Section getPrerequisite() {
        return prerequisite;
    }

    public void setPrerequisite(Section prerequisite) {
        this.prerequisite = prerequisite;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
