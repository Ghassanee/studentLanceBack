package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Entity.JobOpening_User;
import com.StudentLance.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobOpening_UserDAO extends JpaRepository<JobOpening_User,Long> {

    JobOpening_User findByJobOpeningAndUser(JobOpening jobOpening, User user);

    JobOpening_User findByJobUserRef(String jobUserRef);

    List<JobOpening_User> findAllByUser(User user);

    List<JobOpening_User> findAll();

    List<JobOpening_User> findAllByJobOpening(JobOpening jobOpening);

    List<JobOpening_User> findByTerminalTrue();

    List<JobOpening_User> findByStatus(String status);

    List<JobOpening_User> findByInterestedTrue();


}
