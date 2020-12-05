package com.StudentLance.demo.ServiceInterface;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JobOpeningUserServiceInt {
    public boolean markNotInterested(int userId, int jobId);
    public boolean markInterested(int userId, int jobId);
    public List<Integer> getUserInterestJobs(int userId);
    public Object getUserJobStatus(int userid);
    public ResponseEntity apply_Job(int userid, int jobid, String resume);
    public ResponseEntity getUserAllInterestedJobs(int userid);
    public ResponseEntity getCompanyApplications(int jobid);
    public String getActiveCompanyApplications(int jobid);
    public ResponseEntity changeStatus(int applicationId, String status);
    public ResponseEntity reApply(int applcId);

}
