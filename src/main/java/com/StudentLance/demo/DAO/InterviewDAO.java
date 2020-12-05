package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Entity.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterviewDAO extends JpaRepository<Interview,Long> {

    @Query(nativeQuery = true, value = "select * from studentlance.interview where status IN :statuslist")
    public List<Interview> getInterviewByStatus(@Param("statuslist") List<String> statuslist);

}
