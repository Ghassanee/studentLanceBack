package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOpeningDAO extends JpaRepository<JobOpening,Long> {

    JobOpening findByJobOpeningRef(String jobOpeningRef);

    List<JobOpening> findByCompany(Company company);

    List<JobOpening> findByCompanyAndStatus(Company company, String status);

    List<JobOpening> findByLocation(String location);

    List<JobOpening> findAll();

    List<JobOpening> findByTitle(String title);

    List<JobOpening> findByDescription(String description);

    List<JobOpening> findByResponsibilities(String responsibilities);

    List<JobOpening> findBySalary(int salary);

    List<JobOpening> findByStatus(String status);





}
