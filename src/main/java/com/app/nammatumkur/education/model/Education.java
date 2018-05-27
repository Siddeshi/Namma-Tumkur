package com.app.nammatumkur.education.model;

import com.app.nammatumkur.generic.model.ContactDetails;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document
public class Education implements Serializable {

    @Id
    private String id;

    private String name;

    private String about;

    private ContactDetails contactDetails;

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
