package com.StudentLance.demo.REST;


import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Services.JobOpeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/StudentLance/JobOpening")
public class JobOpeningRest {

    @Autowired
    private JobOpeningService jobOpeningService;

    @GetMapping ("/{ref}")
    public ResponseEntity<JobOpening> findByJobOpeningRef(@PathVariable("ref") String ref){
        JobOpening createdJobOpening = jobOpeningService.findByJobOpeningRef(ref);
        return createdJobOpening != null ? ResponseEntity.status(OK)
                .body(createdJobOpening)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping ("/title/{title}")
    public ResponseEntity<List<JobOpening>> findByTitle(@PathVariable("title") String title){
        List<JobOpening> jobOpeningList = jobOpeningService.findByTitle(title);
        return jobOpeningList != null ? ResponseEntity.status(OK)
                .body(jobOpeningList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping ("/description")
    public ResponseEntity<List<JobOpening>> findByDescription(@RequestBody String description) {
        List<JobOpening> jobOpeningList = jobOpeningService.findByDescription(description);
        return jobOpeningList != null ? ResponseEntity.status(OK)
                .body(jobOpeningList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping ("/responsibilities")
    public ResponseEntity<List<JobOpening>> findByResponsibilities(@RequestBody String responsibilities){
        List<JobOpening> jobOpeningList = jobOpeningService.findByResponsibilities(responsibilities);
        return jobOpeningList != null ? ResponseEntity.status(OK)
                .body(jobOpeningList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping ("/salary/{salary}")
    public ResponseEntity<List<JobOpening>> findBySalary(@PathVariable("salary") int salary){
        List<JobOpening> jobOpeningList = jobOpeningService.findBySalary(salary);
        return jobOpeningList != null ? ResponseEntity.status(OK)
                .body(jobOpeningList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping ("/status/{status}")
    public ResponseEntity<List<JobOpening>> findByStatus(@PathVariable("status") String status){
        List<JobOpening> jobOpeningList = jobOpeningService.findByStatus(status);
        return jobOpeningList != null ? ResponseEntity.status(OK)
                .body(jobOpeningList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping ("/company/{company}")
    public ResponseEntity<List<JobOpening>> findByCompany(@PathVariable("company") String company){
        List<JobOpening> jobOpeningList = jobOpeningService.findByCompany(company);
        return jobOpeningList != null ? ResponseEntity.status(OK)
                .body(jobOpeningList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping ("/company/{company}/status/{status}")
    public ResponseEntity<List<JobOpening>> findByCompanyAndStatus(@PathVariable("company") String company, @PathVariable("status") String status){
        List<JobOpening> jobOpeningList = jobOpeningService.findByCompanyAndStatus(company, status);
        return jobOpeningList != null ? ResponseEntity.status(OK)
                .body(jobOpeningList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping ("/location/{location}")
    public ResponseEntity<List<JobOpening>> findByLocation(@PathVariable("location") String location){
        List<JobOpening> jobOpeningList = jobOpeningService.findByLocation(location);
        return jobOpeningList != null ? ResponseEntity.status(OK)
                .body(jobOpeningList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping ("/")
    public ResponseEntity<List<JobOpening>> getAll(){
        List<JobOpening> jobOpeningList = jobOpeningService.getAll();
        return jobOpeningList != null ? ResponseEntity.status(OK)
                .body(jobOpeningList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @PostMapping ("/")
    public ResponseEntity<JobOpening> createJobOpening(@RequestBody JobOpening jobOpening){
        JobOpening jobOpeningList = jobOpeningService.createJobOpening(jobOpening, true);
        return jobOpeningList != null ? ResponseEntity.status(OK)
                .body(jobOpeningList)
                :ResponseEntity.status(FORBIDDEN)
                .body(null);
    }

    @PutMapping ("/update")
    public ResponseEntity<JobOpening> updateJob(@RequestBody JobOpening jobOpening){
        JobOpening jobOpeningList = jobOpeningService.updateJob(jobOpening);
        return jobOpeningList != null ? ResponseEntity.status(OK)
                .body(jobOpeningList)
                :ResponseEntity.status(FORBIDDEN)
                .body(null);
    }

    }


