package com.StudentLance.demo.ServiceInterface;

import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Entity.JobOpening;

import java.util.List;

public interface CompanyServiceInt {
    public Company getCompany(int companyId);
    public List<Company> getAll();
    public Company getCompany(String email);
    public Company createCompany(String companyname, String website, String location, String logoImageUrl, String description, String password, String companyemail);
    public Company updateCompany(String companyName, String website, String location, String logoImageUrl, String description, String password, int companyId);
    public String getJobopeningInCompany(Company company, JobOpening jobopening);
    public String getJobOpenings(Company company, List<JobOpening> jobOpeningList);
    public String getCompany(Company company, int size);
    public String scheduleInterview(int userId, int jobId, int applicationid, String title, String email,
                                    String location, String startTime, String endTime);
    public List<Interview> getInterviewByStatus(String statusList);

}

