package com.StudentLance.demo.ServiceInterface;

import com.StudentLance.demo.Entity.JobOpening_User;

import java.util.List;

public interface JobOpeningUserServiceInt {

    JobOpening_User findByJobOpeningAndUser(String jobOpening, String user);

    JobOpening_User findByJobUserRef(String jobUserRef);

    List<JobOpening_User> findAllByUser(String user);

    List<JobOpening_User> findAllByJobOpening(String jobOpening);

    List<JobOpening_User> findTerminalTrue();

    List<JobOpening_User> findByStatus(String status);

    List<JobOpening_User> findByInterestedTrue();

    List<JobOpening_User> findAll();

    JobOpening_User applyToJob(JobOpening_User jobOpening_user);

    List<JobOpening_User> getCompanyApplications(String company);


}
