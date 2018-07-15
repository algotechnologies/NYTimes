package com.algotechnologies.nytimes.model.dto;

import java.io.Serializable;

/**
 * Created by Saad Aftab on 13/07/2018.
 */
public class Article implements Serializable {

    public String title;
    public String byLine;
    public String details;

    public Article() {
    }

    public Article(String title, String byline, String details) {
        this.title = title;
        this.byLine = byline;
        this.details = details;
    }

    public String getTitle() {
        return title;
    }

    public String getByline() {
        return byLine;
    }

    public String getDetails() {
        return details;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setByLine(String byLine) {
        this.byLine = byLine;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
