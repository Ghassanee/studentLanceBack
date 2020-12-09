package com.StudentLance.demo.Services;


import com.StudentLance.demo.DAO.CompanyDAO;
import com.StudentLance.demo.DAO.JobOpeningDAO;
import com.StudentLance.demo.DAO.JobOpening_UserDAO;
import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Entity.JobOpening_User;
import com.StudentLance.demo.ServiceInterface.JobOpeningServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobOpeningService implements JobOpeningServiceInt{

    @Autowired
    private JobOpeningDAO jobOpeningDao;
    @Autowired
    private CompanyDAO companyDAO;
    @Autowired
    private JobOpening_UserDAO jobOpening_userDAO ;

    @Override
    public List<JobOpening> findByTitle(String title) {
        return jobOpeningDao.findByTitle(title);
    }

    @Override
    public List<JobOpening> findByDescription(String description) {
        return jobOpeningDao.findByDescription(description);
    }

    @Override
    public List<JobOpening> findByResponsibilities(String responsibilities) {
        return jobOpeningDao.findByResponsibilities(responsibilities);
    }

    @Override
    public List<JobOpening> findBySalary(int salary) {
        return jobOpeningDao.findBySalary(salary);
    }

    @Override
    public List<JobOpening> findByStatus(String status) {
        return jobOpeningDao.findByStatus(status);
    }

    @Override
    public List<JobOpening> findByCompany(String company){
        return jobOpeningDao.findByCompany(companyDAO.findByCompanyRef(company));
    }

    @Override
    public List<JobOpening> findByCompanyAndStatus(String company, String status) {
        return jobOpeningDao.findByCompanyAndStatus(companyDAO.findByCompanyRef(company),status);
    }

    @Override
    public List<JobOpening> findByLocation(String location) {
        return jobOpeningDao.findByLocation(location);
    }

    @Override
    public List<JobOpening> getAll() {
        return jobOpeningDao.findAll();
    }

    @Override
    public JobOpening findByJobOpeningRef(String jobOpeningRef){
        return jobOpeningDao.findByJobOpeningRef(jobOpeningRef);
    }

    @Override
    public JobOpening createJobOpening(JobOpening jobOpening, boolean create) {
        try {
            JobOpening foundedJobOpening = jobOpeningDao.findByJobOpeningRef(jobOpening.getJobOpeningRef());
            Company foundedCompany = companyDAO.findByCompanyRef(jobOpening.getCompany().getCompanyRef());
            if (foundedJobOpening != null && create ) throw new Exception("Job Opening Reference already exist!: JobOpeningRef:  "+ jobOpening.getJobOpeningRef());
            else if (foundedJobOpening == null && !create ) throw new Exception("Job Opening Reference doesn't exist!: JobOpeningRef:  "+ jobOpening.getJobOpeningRef());
            else if (foundedCompany == null ) throw new Exception("Company doesn't  exist!: CompanyRef:  " + jobOpening.getCompany().getCompanyRef());
            else {
                for (JobOpening_User j : jobOpening.getJobOpeningUserList()) {
                    if (jobOpening_userDAO.findByJobUserRef(j.getJobUserRef()) == null)
                        throw new Exception("One of JobUser Reference in JobUserList doesn't exist!: JobUserRef:  " + j.getJobUserRef());
                }
            }
        }catch (Exception e){
            System.out.println("Creating a JobOpening failed");
            return null;
        }
        return jobOpeningDao.save(jobOpening);
    }

    @Override
    public JobOpening updateJob(JobOpening jobOpening) {
        return createJobOpening(jobOpening, false);
    }




}



