package com.codeup.springblog.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="ad", schema="spring_db")
public class Ad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(length = 240, nullable = false, unique = true)
    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentAd")
    @JsonManagedReference
    private List<Comment> comments;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="ad_tag",
            joinColumns={@JoinColumn(name="ad_id")},
            inverseJoinColumns={@JoinColumn(name="tag_id")}
    )

    @JsonManagedReference
    private List<Tag> tags;

    public Ad() { }

    public Ad(String title, String description) {
        this.title = title;
        this.description =  description;
    }

    public Ad(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description =  description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}