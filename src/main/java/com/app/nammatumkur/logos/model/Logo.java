package com.app.nammatumkur.logos.model;

import com.app.nammatumkur.category.model.Category;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Document
public class Logo implements Serializable {

    private byte[] image;

    private String filename;

    private String contentType;

    private Date created;

    public Logo() {

    }

    public Logo(byte[] image, String filename, String contentType, Date date) {

        this.image = image;
        this.filename = filename;
        this.contentType = contentType;
        this.created = date;

    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
