package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewDAO extends JpaRepository<Interview,Long> {

    List<Interview> findAllByStatus(String status);

    Interview findByInterviewRef(String interviewRef);

    List<Interview> findAll();

    List<Interview> findByUser(User user);

}
