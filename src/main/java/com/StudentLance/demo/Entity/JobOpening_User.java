package com.StudentLance.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class JobOpening_User implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long jobUserId;
    private String jobUserRef;
    @ManyToOne
    private User user;
    @ManyToOne
    private JobOpening jobOpening;
    private String status;
    private boolean interested;
    private boolean terminal;
    private String resume ;


    public JobOpening_User(String jobUserRef, User user, JobOpening jobOpening, String status, boolean interested, boolean terminal, String resume) {
        this.jobUserRef = jobUserRef;
        this.user = user;
        this.jobOpening = jobOpening;
        this.status = status;
        this.interested = interested;
        this.terminal = terminal;
        this.resume = resume;
    }

    public long getJobUserId() {
        return jobUserId;
    }

    public void setJobUserId(long jobUserId) {
        this.jobUserId = jobUserId;
    }

    public String getJobUserRef() {
        return jobUserRef;
    }

    public void setJobUserRef(String jobUserRef) {
        this.jobUserRef = jobUserRef;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isInterested() {
        return interested;
    }

    public void setInterested(boolean interested) {
        this.interested = interested;
    }

    public boolean isTerminal() {
        return terminal;
    }

    public void setTerminal(boolean terminal) {
        this.terminal = terminal;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
