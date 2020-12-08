package com.StudentLance.demo.ServiceInterface;

import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.JobOpening;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.Optional;

public interface JobOpeningServiceInt {

    JobOpening findByJobOpeningRef(String jobOpeningRef);

    List<JobOpening> findByCompany(String company);

    List<JobOpening> findByCompanyAndStatus(String company, String status);

    List<JobOpening> findByLocation(String location);

    List<JobOpening> getAll();

    JobOpening createJobOpening(JobOpening jobOpening, boolean create);

    JobOpening updateJob(JobOpening jobOpening);

    List<JobOpening> findByTitle(String title);

    List<JobOpening> findByDescription(String description);

    List<JobOpening> findByResponsibilities(String responsibilities);

    List<JobOpening> findBySalary(int salary);

    List<JobOpening> findByStatus(String status);

}


