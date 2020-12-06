package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.JobOpening_User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOpening_UserDAO extends JpaRepository<JobOpening_User,Long> {
    @Query("select * from JobOpening_User j  where j.jobUserId = :job_userId")
    JobOpening_User findByJob_userId(@Param("job_userId") int job_userId);

    @Query( "select * from  JobOpening_User j  where j.userId = :userId AND j.jobId = :jobId")
    JobOpening_User checkEntry(@Param("userId") int userId, @Param("jobId") int jobId);

    @Query( "select distinct j.jobId from JobOpening_User j where j.interested = 1 and j.userId = :userId")
    List<Integer> getUserInterestJobs(@Param("userId") int userId);

    @Query( "select * from JobOpening_User j where j.userId = :userId")
    List<JobOpening_User> getUserJobStatus(@Param("userId") int userId);

    @Query( "select * from JobOpening_User j where j.jobId = :jobId")
    List<JobOpening_User> getCompanyApplication(@Param("jobId") int jobId);

    @Query( "select * from JobOpening_User j where j.userId = :userId")
    List<JobOpening_User> getInterestedJobs(@Param("userId") int userid);

    @Query( "select * from JobOpening_User j where j.jobId = :jobId AND j.terminal = 0")
    List<JobOpening_User> getActiveCompanyApplications(@Param("jobId") int jobId);

    @Query( "select * from JobOpening_User j where j.userId = :userId")
    List<JobOpening_User> getUserInterviews(@Param("userId") int userid);

    @Query( "select * from JobOpening_User j where j.status = 'OfferAccepted' and j.jobId = :jobId")
    List<JobOpening_User> getOfferJobs(@Param("jobId") int jobid);

    @Query( "select * from JobOpening_User j where (j.status = 'Applied' or j.status like '%Interview%' or j.status = 'offered') and j.jobId = :jobId")
    List<JobOpening_User> getNonTerminalApplications(@Param("jobId") int jobid);


}
