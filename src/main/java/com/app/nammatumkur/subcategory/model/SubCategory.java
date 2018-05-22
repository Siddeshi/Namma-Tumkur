package com.app.nammatumkur.subcategory.model;

import com.app.nammatumkur.logos.model.Logo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class SubCategory implements Serializable {

    @Id
    private String id;

    private String type;

    private String name;

    private Logo logo;

    public SubCategory() {

    }

    public SubCategory(String id, String type, String name, Logo logo) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.logo = logo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Logo getLogo() {
        return logo;
    }

    public void setLogo(Logo logo) {
        this.logo = logo;
    }
}
