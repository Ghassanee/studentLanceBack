package com.StudentLance.demo.Services;

import com.StudentLance.demo.DAO.InterviewDAO;
import com.StudentLance.demo.DAO.JobOpeningDAO;
import com.StudentLance.demo.DAO.UserDAO;
import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Entity.User;
import com.StudentLance.demo.ServiceInterface.InterviewServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService implements InterviewServiceInt {

    @Autowired
    private InterviewDAO interviewDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private JobOpeningDAO jobOpeningDAO;

    @Override
    public List<Interview> findAllByStatus(String status) {
        return interviewDAO.findAllByStatus(status);
    }

    @Override
    public List<Interview> findAll() {
        return interviewDAO.findAll();
    }

    @Override
    public Interview scheduleInterview(Interview interview) {
        try {
            Interview foundedInterviewByRef = interviewDAO.findByInterviewRef(interview.getInterviewRef());
            User foundedInterviewUser = userDAO.findByUserRef(interview.getUser().getUserRef());
            JobOpening foundedInterviewJobOpening = jobOpeningDAO.findByJobOpeningRef(interview.getJobOpening().getJobOpeningRef());
            if (foundedInterviewByRef != null ) throw new Exception("Interview Reference already exist!: interviewRef:  "+ interview.getInterviewRef());
            else if (foundedInterviewUser == null ) throw new Exception("User doesn't  exist!: userRef:  " + interview.getUser().getUserRef());
            else if (foundedInterviewJobOpening == null ) throw new Exception("JobOpening doesn't  exist!: jobOpeningRef:  " + interview.getJobOpening().getJobOpeningRef());

        }catch (Exception e){
            System.out.println("Scheduling an Interview failed");
        }
        return interviewDAO.save(interview);
    }

    @Override
    public Interview findByInterviewRef(String interviewRef) {
        return interviewDAO.findByInterviewRef(interviewRef);
    }


}
