package com.StudentLance.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "user_entity")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long userId;
    private String userRef;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String password;
    private String address;
    private String introduction;
    private float experience;
    private String education;
    private String status;
    private String skills;
    private ImageModel photo;
    @OneToMany
    private List<JobOpening_User> jobOpeningUserList;

    public User(String userRef, String firstname, String lastname, String phone, String email, String password, String address, String introduction, float experience, String education, String status, String skills, ImageModel photo) {
        this.userRef = userRef;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.introduction = introduction;
        this.experience = experience;
        this.education = education;
        this.status = status;
        this.skills = skills;
        this.photo = photo;
        this.jobOpeningUserList = new ArrayList<>();
    }

    public User() {
    }

    public List<JobOpening_User> getJobOpeningUserList() {
        return jobOpeningUserList;
    }

    public void setJobOpeningUserList(List<JobOpening_User> jobOpeningUserList) {
        this.jobOpeningUserList = jobOpeningUserList;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserRef() {
        return userRef;
    }

    public void setUserRef(String userRef) {
        this.userRef = userRef;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public float getExperience() {
        return experience;
    }

    public void setExperience(float experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public ImageModel getPhoto() {
        return photo;
    }

    public void setPhoto(ImageModel photo) {
        this.photo = photo;
    }
}
