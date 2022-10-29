package org.example.dto;


import java.time.LocalDateTime;

public class Word {
    private Integer id;
    private String name;
    private String translate;
    private String description;
    private LocalDateTime created_date;

    public Word() {
    }

    public Word(String name, String translate, String description, LocalDateTime created_date) {
        this.name = name;
        this.translate = translate;
        this.description = description;
        this.created_date = created_date;
    }

    public Word(Integer id, String name, String translate, String description, LocalDateTime created_date) {
        this.id = id;
        this.name = name;
        this.translate = translate;
        this.description = description;
        this.created_date = created_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }

    @Override
    public String toString() {
        return id+". "+name+" -> "+translate+" -> "+description;
    }
}
