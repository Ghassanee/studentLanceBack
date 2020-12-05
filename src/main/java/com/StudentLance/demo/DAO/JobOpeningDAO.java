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

    @Query(nativeQuery = true, value = "select * from studentlance.job_opening where company_id = ?")
    public List<JobOpening> findJobOpeningsInCompany(String companyid);

    @Query(nativeQuery = true, value = "select * from studentlance.job_opening where job_Id = ?")
    public JobOpening findJobOpeningByJobId(int jobId);

    @Query(nativeQuery = true, value = "select * from studentlance.job_opening where status IN :statuslist AND company_id = :companyid")
    public  List<JobOpening> findJobOpeningsInCompanyByStatus(@Param("companyid") String companyid, @Param("statuslist") List<String> statuslist);

    @Query(nativeQuery = true, value = "select job_Id from studentlance.job_opening where companyname IN :companies AND status = 'Open'")
    public  List<Integer> findJobOpeningsInCompanyByName(@Param("companies") List<String> companies);

    @Query(nativeQuery = true, value = "select job_Id from studentlance.job_opening where location IN :locations AND status = 'Open'")
    public  List<Integer> findJobOpeningsInCompanyByLocation(@Param("locations") List<String> locations);



    @Query(nativeQuery = true, value = "select job_Id from studentlance.job_opening where salary > :salarystart AND salary < :salaryend AND status = 'Open'")
    public  List<Integer> findJobOpeningsInCompanyBySalary(@Param("salarystart") int salarystart, @Param("salaryend") int salaryend);


    @Query(nativeQuery = true, value = "select * from studentlance.job_opening where job_Id IN :jobId")
    public  List<JobOpening> findJobOpeningsInCompanyByFilter(@Param("jobId") List<Integer> jobId);

    @Query(value = "select * from studentlance.job_opening where status = 'Open'", nativeQuery = true)
    List<JobOpening> getAllJobs();

    @Query(value = "select distinct location from studentlance.job_opening", nativeQuery = true)
    List<String> getAllLocations();



}
