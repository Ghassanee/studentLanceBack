package com.StudentLance.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Interview implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long interviewId;
    private String interviewRef;
    @ManyToOne
    private User user;
    @ManyToOne
    private JobOpening jobOpening;
    private String status;
    private String location;
    private Date time;
    private String feedback;


    public Interview(String interviewRef, User user, JobOpening jobOpening, String status, String location, Date time, String feedback) {
        this.interviewRef = interviewRef;
        this.user = user;
        this.jobOpening = jobOpening;
        this.status = status;
        this.location = location;
        this.time = time;
        this.feedback = feedback;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public JobOpening getJobOpening() {
        return jobOpening;
    }

    public void setJobOpening(JobOpening jobOpening) {
        this.jobOpening = jobOpening;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public long getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(long interviewId) {
        this.interviewId = interviewId;
    }

    public String getInterviewRef() {
        return interviewRef;
    }

    public void setInterviewRef(String interviewRef) {
        this.interviewRef = interviewRef;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
