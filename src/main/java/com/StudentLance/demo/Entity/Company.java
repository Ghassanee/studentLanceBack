package com.StudentLance.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Company {

    private String companyname;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int companyId;
    private String website;
    private String location;
    private String logo_image_URL ;
    private String description ;
    private String companyemail ;
    private String passeword ;


    public String getPasseword() {
        return passeword;
    }

    public String getCompanyemail() {
        return companyemail;
    }

    public void setCompanyemail(String companyemail) {
        this.companyemail = companyemail;
    }

    public Company() {
    }

    public Company(String companyname, String website, String location, String logoImageUrl, String description, String password, String companyemail) {
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLogo_image_URL() {
        return logo_image_URL;
    }

    public void setLogo_image_URL(String logo_image_URL) {
        this.logo_image_URL = logo_image_URL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


