package com.StudentLance.demo.REST;

import com.StudentLance.demo.Entity.JobOpening_User;
import com.StudentLance.demo.Services.JopOpeningUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/StudentLance/JobOpeninng_User")

public class JopOpening_UserRest {

    @Autowired
    private JopOpeningUserService jobOpeningUserService ;

    @GetMapping("/{ref}")
    public ResponseEntity<JobOpening_User> findByJobUserRef(@PathVariable("ref") String ref) {
        JobOpening_User JobOpeningUser = jobOpeningUserService.findByJobUserRef(ref);
        return JobOpeningUser != null ? ResponseEntity.status(OK)
                .body(JobOpeningUser)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/job&user/{jobOpening}/{user}")
    public ResponseEntity<JobOpening_User> findByJobOpeningAndUser(@PathVariable("jobOpening") String jobOpening,@PathVariable("user") String user) {
        JobOpening_User createdJobOpeningUser = jobOpeningUserService.findByJobOpeningAndUser(jobOpening, user);
        return createdJobOpeningUser != null ? ResponseEntity.status(OK)
                .body(createdJobOpeningUser)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/user/{user}")
    public ResponseEntity <List<JobOpening_User>> findAllByUser(@PathVariable("user") String user) {
        List<JobOpening_User> jobOpeningUsers = jobOpeningUserService.findAllByUser(user);
        return jobOpeningUsers != null ? ResponseEntity.status(OK)
                .body(jobOpeningUsers)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/jobOpening/{jobOpening}")
    public ResponseEntity<List<JobOpening_User>> findAllByJobOpening(@PathVariable("jobOpening") String jobOpening) {
        List<JobOpening_User> jobOpeningUsers = jobOpeningUserService.findAllByJobOpening(jobOpening);
        return jobOpeningUsers != null ? ResponseEntity.status(OK)
                .body(jobOpeningUsers)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/terminal")
    public ResponseEntity<List<JobOpening_User>> findTerminalTrue() {
        List<JobOpening_User> jobOpeningUsers = jobOpeningUserService.findTerminalTrue();
        return jobOpeningUsers != null ? ResponseEntity.status(OK)
                .body(jobOpeningUsers)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<JobOpening_User>> findByStatus(@PathVariable("status") String status) {
        List<JobOpening_User> jobOpeningUsers = jobOpeningUserService.findByStatus(status);
        return jobOpeningUsers != null ? ResponseEntity.status(OK)
                .body(jobOpeningUsers)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/interested")
    public ResponseEntity<List<JobOpening_User>> findByInterestedTrue() {
        List<JobOpening_User> jobOpeningUsers = jobOpeningUserService.findByInterestedTrue();
        return jobOpeningUsers != null ? ResponseEntity.status(OK)
                .body(jobOpeningUsers)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/")
    public ResponseEntity<List<JobOpening_User>> findAll() {
        List<JobOpening_User> jobOpeningUsers = jobOpeningUserService.findAll();
        return jobOpeningUsers != null ? ResponseEntity.status(OK)
                .body(jobOpeningUsers)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @PostMapping("/")
    public ResponseEntity<JobOpening_User> applyToJob(@RequestBody JobOpening_User jobOpening_user) {
        JobOpening_User createdJobOpeningUser = jobOpeningUserService.applyToJob(jobOpening_user);
        return createdJobOpeningUser != null ? ResponseEntity.status(OK)
                .body(createdJobOpeningUser)
                :ResponseEntity.status(FORBIDDEN)
                .body(null);
    }





}
