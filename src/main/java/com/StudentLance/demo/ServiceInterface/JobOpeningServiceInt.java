package com.StudentLance.demo.ServiceInterface;

import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.JobOpening;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

public interface JobOpeningServiceInt {
    public Optional<JobOpening> getJobOpening(int jobId);
    public JobOpening createJobOpening(Company company, String title, String description, String responsibilities, String location, String salary);
    public List<JobOpening> getJobOpeningsInCompany(String companyId);
    public List<JobOpening> getJobOpeningsInCompany(String companyId, List<String> statuslist);
    public JobOpening getJobOpeningByJobId(String jobId);
    public String getJobOpeningsByFilters(String companynames, String locations, String salaryStart, String salaryEnd);
    public Object getAllOpenJobs();
    public ModelMap getAllFilters();
    public ResponseEntity updateJob(int jobid, String emails, int companyId, String companyname, String title, String description,
                                    String responsibilities, String location, int salary, String status);
    public ResponseEntity updateJobOpening(int jobid, String status);

}


