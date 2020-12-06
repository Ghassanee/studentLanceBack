package com.StudentLance.demo.Entity;

import javax.persistence.*;

@Entity
public class JobOpening_User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int jobUserId;
    private int userId;
    private int jobId;
    private int companyId;
    private String status;
    private boolean interested;
    private boolean terminal;
    private String resume ;

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public JobOpening_User() {
    }

    public JobOpening_User(int userId, int jobId, int companyId, Object o, boolean b, boolean b1) {
    }

    public int getJobUserId() {
        return jobUserId;
    }

    public void setJobUserId(int jobUserId) {
        this.jobUserId = jobUserId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
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
}
