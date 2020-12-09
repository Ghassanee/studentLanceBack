package com.StudentLance.demo.Services;

import com.StudentLance.demo.DAO.JobOpeningDAO;
import com.StudentLance.demo.DAO.JobOpening_UserDAO;
import com.StudentLance.demo.DAO.UserDAO;
import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Entity.JobOpening_User;
import com.StudentLance.demo.Entity.User;
import com.StudentLance.demo.ServiceInterface.JobOpeningUserServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JopOpeningUserService implements JobOpeningUserServiceInt {
    @Autowired
    private JobOpeningDAO jobOpeningDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private JobOpening_UserDAO jobOpeningUserDAO;


    @Override
    public JobOpening_User findByJobOpeningAndUser(String jobOpening, String user) {
        JobOpening foundedJobOpening = jobOpeningDAO.findByJobOpeningRef(jobOpening);
        User foundedUser = userDAO.findByUserRef(user);
        try {
            if (foundedUser == null) throw new Exception("User not found for this JobUser, User Ref :" + user);
            if (foundedJobOpening == null) throw new Exception("Job not found for this JobUser, Job Ref :" + jobOpening);

        }catch (Exception e){
            System.out.println("failed to find JobUser");
        }
        return jobOpeningUserDAO.findByJobOpeningAndUser(foundedJobOpening, foundedUser);
    }

    @Override
    public JobOpening_User findByJobUserRef(String jobUserRef) {
        return jobOpeningUserDAO.findByJobUserRef(jobUserRef);
    }

    @Override
    public List<JobOpening_User> findAllByUser(String user) {
        User foundedUser = userDAO.findByUserRef(user);
        try {
            if (foundedUser == null) throw new Exception("User not found for this JobUser, User Ref :" + user);

        }catch (Exception e){
            System.out.println("failed to find JobUser");
        }
        return jobOpeningUserDAO.findAllByUser(foundedUser);
    }

    @Override
    public List<JobOpening_User> findAllByJobOpening(String jobOpening) {
        JobOpening foundedJobOpening = jobOpeningDAO.findByJobOpeningRef(jobOpening);
        try {
            if (foundedJobOpening == null) throw new Exception("Job not found for this JobUser, Job Ref :" + jobOpening);

        }catch (Exception e){
            System.out.println("failed to find JobUser");
        }
        return jobOpeningUserDAO.findAllByJobOpening(foundedJobOpening);
    }

    @Override
    public List<JobOpening_User> findTerminalTrue() {
        return jobOpeningUserDAO.findByTerminalTrue();
    }

    @Override
    public List<JobOpening_User> findByStatus(String status) {
        return jobOpeningUserDAO.findByStatus(status);
    }

    @Override
    public List<JobOpening_User> findByInterestedTrue() {
        return jobOpeningUserDAO.findByInterestedTrue();
    }

    @Override
    public List<JobOpening_User> findAll() {
        return jobOpeningUserDAO.findAll();
    }

    @Override
    public List<JobOpening_User> getCompanyApplications(String company) {
        return jobOpeningUserDAO.findAll().stream().filter(t -> t.getJobOpening().getCompany().getCompanyRef().equals(company)).collect(Collectors.toList());
    }

    @Override
    public JobOpening_User applyToJob(JobOpening_User jobOpening_user) {
        try {
            JobOpening_User foundedJobUser = jobOpeningUserDAO.findByJobUserRef(jobOpening_user.getJobUserRef());
            JobOpening foundedJobOpening = jobOpeningDAO.findByJobOpeningRef(jobOpening_user.getJobOpening().getJobOpeningRef());
            User foundedUser = userDAO.findByUserRef(jobOpening_user.getUser().getUserRef());
            if (foundedJobUser != null ) throw new Exception("JobUser Reference already exist!: getJobUserRef:  "+ jobOpening_user.getJobUserRef());
            else if (foundedJobOpening == null  ) throw new Exception("Job Opening Reference doesn't exist!: JobOpeningRef:  "+ jobOpening_user.getJobOpening().getJobOpeningRef());
            else if (foundedUser == null ) throw new Exception("User doesn't  exist!: getUserRef:  " + jobOpening_user.getUser().getUserRef());
        }catch (Exception e){
            System.out.println("Creating a JobOpening_User failed");
            return null;
        }
        return jobOpeningUserDAO.save(jobOpening_user);
    }


}
