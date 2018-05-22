package com.app.nammatumkur.category.model;

import com.app.nammatumkur.logos.model.Logo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Category implements Serializable {

    @Id
    private String catId;

    private String type;

    private Logo logo;

    public Category() {

    }

    public Category(String catId, String type, Logo logo) {
        this.type = type;
        this.type = type;
        this.logo = logo;
    }

    public String getCatId() {
        return catId;
    }

    public String getType() {
        return type;
    }

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Logo getLogos() {
        return logo;
    }

    public void setLogos(Logo logos) {
        this.logo = logos;
    }
}
