package com.StudentLance.demo.REST;

import com.StudentLance.demo.Services.CompanyService;
import com.StudentLance.demo.Services.JobOpeningService;
import com.StudentLance.demo.Services.JopOpeningUserService;
import com.StudentLance.demo.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/StudentLance/JobOpeninng_User")

public class JopOpening_UserRest {
    @Autowired
    private CompanyService companyService;

    @Autowired
    private UserService userService;

    @Autowired
    private JobOpeningService jobOpeningService;

    @Autowired
    private JopOpeningUserService jobOpeningUserService ;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @PostMapping("/userJob/interest")
    public ResponseEntity markInterested(@RequestParam Map<String,String> params) {

        int userId = Integer.valueOf(params.get("userId"));
        int jobId = Integer.valueOf(params.get("jobId"));
        boolean markedInterest =  jobOpeningUserService.markInterested(userId, jobId);

        if(markedInterest){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return null;
        }

    }

    @PostMapping("/userJob/notInterest")
    public ResponseEntity markNotInterested(@RequestParam Map<String,String> params) {

        int userId = Integer.valueOf(params.get("userId"));
        int jobId = Integer.valueOf(params.get("jobId"));

        boolean markedNotInterest =  jobOpeningUserService.markNotInterested(userId, jobId);

        if(markedNotInterest){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }


    @PostMapping(value ="/userJob/applyResume")
    public void user_applyResume() {

    }

    @GetMapping("/company/getApplication")
    public ResponseEntity getCompanyApplications(@RequestParam(value="jobid") String jobid) {

        try{

            return jobOpeningUserService.getCompanyApplications(Integer.valueOf(jobid));

        }catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/users/getInterestedJobs/{id}")
    public ResponseEntity getUserAllInterestedJobs(@PathVariable(value="id") String userid) {

        return jobOpeningUserService.getUserAllInterestedJobs(Integer.valueOf(userid));


    }

    @GetMapping("/userJob/interestedJobs/{id}")
    public ResponseEntity getUser_interestedJobs(@PathVariable(value="id") String id) {

        try{
            Object obj = jobOpeningUserService.getUserJobStatus(Integer.valueOf(id));

            ModelMap m = new ModelMap();
            m.addAttribute("jobStatus", obj);
            m.addAttribute("interests", jobOpeningUserService.getUserInterestJobs(Integer.valueOf(id)));

            return new ResponseEntity(m, HttpStatus.OK);

        }catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/userJob/apply")
    public ResponseEntity apply_Job(@RequestParam Map<String,String> params) {

        String resume;

        if(params.get("resume") != null){
            resume = params.get("resume");

        }else{
            resume = null;
        }

        return jobOpeningUserService.apply_Job(Integer.valueOf(params.get("userid")), Integer.valueOf(params.get("jobid")), resume);
    }

    @PostMapping("/userJob/changeStatus")
    public ResponseEntity changeStatus(@RequestParam Map<String,String> params) {

        int applicationId = Integer.valueOf(params.get("applicationId"));
        String status = params.get("status");

        // return jobOpening_userService.changeStatus(applicationId, status);
        return jobOpeningUserService.changeStatus(applicationId, status);
    }


    @PostMapping("/userJob/reapply")
    public ResponseEntity reApply(@RequestParam Map<String,String> params) {

        int applicationId = Integer.valueOf(params.get("applicationId"));

        return jobOpeningUserService.reApply(applicationId);
    }


}
