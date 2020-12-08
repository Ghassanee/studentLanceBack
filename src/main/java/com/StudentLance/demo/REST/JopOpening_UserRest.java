package com.StudentLance.demo.REST;

import com.StudentLance.demo.Entity.JobOpening_User;
import com.StudentLance.demo.Services.JopOpeningUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/StudentLance/JobOpeninng_User")

public class JopOpening_UserRest {

    @Autowired
    private JopOpeningUserService jobOpeningUserService ;

    @GetMapping("/{ref}")
    public ResponseEntity<JobOpening_User> findByJobUserRef(@PathVariable("ref") String ref) {
        return ResponseEntity.status(OK)
                .body(jobOpeningUserService.findByJobUserRef(ref));
    }

    @GetMapping("/job&user/{jobOpening}/{user}")
    public ResponseEntity<JobOpening_User> findByJobOpeningAndUser(@PathVariable("jobOpening") String jobOpening,@PathVariable("user") String user) {
        return ResponseEntity.status(OK)
                .body(jobOpeningUserService.findByJobOpeningAndUser(jobOpening, user));
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<List<JobOpening_User>> findAllByUser(@PathVariable("user") String user) {
        return ResponseEntity.status(OK)
                .body(jobOpeningUserService.findAllByUser(user));
    }

    @GetMapping("/jobOpening/{jobOpening}")
    public ResponseEntity<List<JobOpening_User>> findAllByJobOpening(@PathVariable("jobOpening") String jobOpening) {
        return ResponseEntity.status(OK)
                .body(jobOpeningUserService.findAllByJobOpening(jobOpening));
    }

    @GetMapping("/terminal")
    public ResponseEntity<List<JobOpening_User>> findTerminalTrue() {
        return ResponseEntity.status(OK)
                .body(jobOpeningUserService.findTerminalTrue());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<JobOpening_User>> findByStatus(@PathVariable("status") String status) {
        return ResponseEntity.status(OK)
                .body(jobOpeningUserService.findByStatus(status));
    }

    @GetMapping("/interested")
    public ResponseEntity<List<JobOpening_User>> findByInterestedTrue() {
        return ResponseEntity.status(OK)
                .body(jobOpeningUserService.findByInterestedTrue());
    }

    @GetMapping("/")
    public ResponseEntity<List<JobOpening_User>> findAll() {
        return ResponseEntity.status(OK)
                .body(jobOpeningUserService.findAll());
    }

    @PutMapping("/")
    public ResponseEntity<JobOpening_User> applyToJob(@RequestBody JobOpening_User jobOpening_user) {
        return ResponseEntity.status(OK)
                .body(jobOpeningUserService.applyToJob(jobOpening_user));
    }





}
