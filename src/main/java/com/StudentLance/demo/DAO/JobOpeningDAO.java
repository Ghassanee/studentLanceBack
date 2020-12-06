package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOpeningDAO extends JpaRepository<JobOpening,Long> {
    public JobOpening findByJobId(int jobId);

    @Query("select * from JobOpening j where j.companyId = :companyId ")
    public List<JobOpening> findJobOpeningsInCompany(@Param("companyId") String companyid);

    @Query("select * from JobOpening j where j.jobId = :jobId")
    public JobOpening findJobOpeningByJobId(@Param("jobId") int jobId);

    @Query("select * from JobOpening j where j.status IN :statuslist AND j.companyId = :companyid")
    public  List<JobOpening> findJobOpeningsInCompanyByStatus(@Param("companyid") String companyid, @Param("statuslist") List<String> statuslist);

    @Query( "select j.jobId from JobOpening j where j.companyname IN :companies AND j.status = 'Open'")
    public  List<Integer> findJobOpeningsInCompanyByName(@Param("companies") List<String> companies);

    @Query( "select j.jobId from JobOpening j where j.location IN :locations AND j.status = 'Open'")
    public  List<Integer> findJobOpeningsInCompanyByLocation(@Param("locations") List<String> locations);



    @Query("select j.jobId from JobOpening j where j.salary > :salarystart AND j.salary < :salaryend AND j.status = 'Open'")
    public  List<Integer> findJobOpeningsInCompanyBySalary(@Param("salarystart") int salarystart, @Param("salaryend") int salaryend);


    @Query( "select * from JobOpening j where j.jobId IN :jobId")
    public  List<JobOpening> findJobOpeningsInCompanyByFilter(@Param("jobId") List<Integer> jobId);

    @Query("select * from JobOpening j where j.status = 'Open'")
    List<JobOpening> getAllJobs();

    @Query( "select distinct j.location from JobOpening j")
    List<String> getAllLocations();



}
