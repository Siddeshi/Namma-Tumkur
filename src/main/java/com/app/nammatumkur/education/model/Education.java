package com.app.nammatumkur.education.model;

import com.app.nammatumkur.logos.model.Logo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Education implements Serializable {

    @Id
    private String id;
    private String type;
    private Logo logos;


    public String getCatId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setCatId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Logo getLogos() {
        return logos;
    }

    public void setLogos(Logo logos) {
        this.logos = logos;
    }
}
