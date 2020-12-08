package com.StudentLance.demo.ServiceInterface;

import com.StudentLance.demo.Entity.Interview;

import java.util.List;

public interface InterviewServiceInt {

    List<Interview> findAllByStatus(String status);

    List<Interview> findAll();

    Interview scheduleInterview(Interview interview);

    Interview findByInterviewRef(String interviewRef);

}
