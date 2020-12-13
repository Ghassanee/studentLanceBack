package com.StudentLance.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
@Entity
public class JobOpening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jobId;
    private String jobOpeningRef;
    @ManyToOne
    private Company company;
    private String title;
    private String description;
    private String responsibilities;
    private String location;
    private int salary;
    private String status;
    @OneToMany(cascade = CascadeType.ALL)
    private List<JobOpening_User> jobOpeningUserList;

    public JobOpening() {
        this.jobOpeningUserList = new ArrayList<>();
    }

    public JobOpening(String jobOpeningRef, Company company, String title, String description, String responsibilities, String location, int salary, String status, List<JobOpening_User> jobOpeningUserList) {
        this.jobOpeningRef = jobOpeningRef;
        this.company = company;
        this.title = title;
        this.description = description;
        this.responsibilities = responsibilities;
        this.location = location;
        this.salary = salary;
        this.status = status;
        this.jobOpeningUserList = jobOpeningUserList;
    }

    public List<JobOpening_User> getJobOpeningUserList() {
        return jobOpeningUserList;
    }

    public void setJobOpeningUserList(List<JobOpening_User> jobOpeningUserList) {
        this.jobOpeningUserList = jobOpeningUserList;
    }

    public long getJobId() {
        return jobId;
    }

    public void setJobId(long jobId) {
        this.jobId = jobId;
    }

    public String getJobOpeningRef() {
        return jobOpeningRef;
    }

    public void setJobOpeningRef(String jobOpeningRef) {
        this.jobOpeningRef = jobOpeningRef;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    }

