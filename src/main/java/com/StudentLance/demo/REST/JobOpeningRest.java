package com.StudentLance.demo.REST;


import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Services.JobOpeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/StudentLance/JobOpening")
public class JobOpeningRest {

    @Autowired
    private JobOpeningService jobOpeningService;

    @GetMapping ("/{ref}")
    public ResponseEntity<JobOpening> findByJobOpeningRef(@PathVariable("ref") String ref){
        return ResponseEntity.status(OK)
                .body(jobOpeningService.findByJobOpeningRef(ref));
    }

    @GetMapping ("/title/{title}")
    public ResponseEntity<List<JobOpening>> findByTitle(@PathVariable("title") String title){
        return ResponseEntity.status(OK)
                .body(jobOpeningService.findByTitle(title));
    }

    @GetMapping ("/description")
    public ResponseEntity<List<JobOpening>> findByDescription(@RequestBody String description) {
        return ResponseEntity.status(OK)
                .body(jobOpeningService.findByDescription(description));
    }

    @GetMapping ("/responsibilities")
    public ResponseEntity<List<JobOpening>> findByResponsibilities(@RequestBody String responsibilities){
        return ResponseEntity.status(OK)
                .body(jobOpeningService.findByResponsibilities(responsibilities));
    }

    @GetMapping ("/salary/{salary}")
    public ResponseEntity<List<JobOpening>> findBySalary(@PathVariable("salary") int salary){
        return ResponseEntity.status(OK)
                .body(jobOpeningService.findBySalary(salary));
    }

    @GetMapping ("/status/{status}")
    public ResponseEntity<List<JobOpening>> findByStatus(@PathVariable("status") String status){
        return ResponseEntity.status(OK)
                .body(jobOpeningService.findByStatus(status));
    }

    @GetMapping ("/company/{company}")
    public ResponseEntity<List<JobOpening>> findByCompany(@PathVariable("company") String company){
        return ResponseEntity.status(OK)
                .body(jobOpeningService.findByCompany(company));
    }

    @GetMapping ("/company/{company}/status/{status}")
    public ResponseEntity<List<JobOpening>> findByCompanyAndStatus(@PathVariable("company") String company, @PathVariable("status") String status){
        return ResponseEntity.status(OK)
                .body(jobOpeningService.findByCompanyAndStatus(company, status));
    }

    @GetMapping ("/location/{location}")
    public ResponseEntity<List<JobOpening>> findByLocation(@PathVariable("location") String location){
        return ResponseEntity.status(OK)
                .body(jobOpeningService.findByLocation(location));
    }

    @GetMapping ("/")
    public ResponseEntity<List<JobOpening>> getAll(){
        return ResponseEntity.status(OK)
                .body(jobOpeningService.getAll());
    }

    @PostMapping ("/")
    public ResponseEntity<JobOpening> createJobOpening(@RequestBody JobOpening jobOpening){
        return ResponseEntity.status(OK)
                .body(jobOpeningService.createJobOpening(jobOpening, true));
    }

    @PostMapping ("/update")
    public ResponseEntity<JobOpening> updateJob(@RequestBody JobOpening jobOpening){
        return ResponseEntity.status(OK)
                .body(jobOpeningService.updateJob(jobOpening));
    }

    }


