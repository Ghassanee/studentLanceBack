package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.JobOpening_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOpening_UserDAO extends JpaRepository<JobOpening_User,Long> {
    @Query(value = "select * from studentlance.job_opening_user where job_userId = ?", nativeQuery = true)
    JobOpening_User findByJob_userId(int job_userId);

    @Query(value = "select * from studentlance.job_opening_user where user_Id = :userId AND job_Id = :jobId", nativeQuery = true)
    JobOpening_User checkEntry(@Param("userId") int userId, @Param("jobId") int jobId);

    @Query(value = "select distinct jobId from studentlance.job_opening_user where interested = 1 and user_Id = ?", nativeQuery = true)
    List<Integer> getUserInterestJobs(@Param("userId") int userId);


    @Query(value = "select * from studentlance.job_opening_user where user_Id = ?", nativeQuery = true)
    List<JobOpening_User> getUserJobStatus(@Param("userId") int userId);

    @Query(value = "select * from studentlance.job_opening_user where job_Id = ?", nativeQuery = true)
    List<JobOpening_User> getCompanyApplication(int jobId);

    @Query(value = "select * from studentlance.job_opening_user where user_Id = ?", nativeQuery = true)
    List<JobOpening_User> getInterestedJobs(int userid);

    @Query(value = "select * from studentlance.job_opening_user where job_Id = ? AND terminal = 0", nativeQuery = true)
    List<JobOpening_User> getActiveCompanyApplications(int jobId);

    @Query(value = "select * from studentlance.job_opening_user where user_Id = ?", nativeQuery = true)
    List<JobOpening_User> getUserInterviews(int userid);

    @Query(value = "select * from studentlance.job_opening_user where status = 'OfferAccepted' and job_Id = ?", nativeQuery = true)
    List<JobOpening_User> getOfferJobs(int jobid);

    @Query(value = "select * from studentlance.job_opening_user where (status = 'Applied' or status like '%Interview%' or status = 'offered') and job_Id = ?", nativeQuery = true)
    List<JobOpening_User> getNonTerminalApplications(int jobid);


}
