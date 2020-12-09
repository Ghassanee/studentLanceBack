package com.StudentLance.demo.REST;


import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/StudentLance/interview")
public class InterviewRest {

    @Autowired
    private InterviewService interviewService;


    @GetMapping("/status/{status}")
    public ResponseEntity<List<Interview>> findAllByStatus(@PathVariable("status") String status) {
        List<Interview> createdJobOpening = interviewService.findAllByStatus(status);
        return createdJobOpening != null ? ResponseEntity.status(OK)
                .body(createdJobOpening)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/{interviewRef}")
    public ResponseEntity<Interview> findByInterviewRef(@PathVariable("interviewRef") String interviewRef) {
        Interview createdJobOpening = interviewService.findByInterviewRef(interviewRef);
        return createdJobOpening != null ? ResponseEntity.status(OK)
                .body(createdJobOpening)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/")
    public ResponseEntity<List<Interview>> findAll() {
        List<Interview> createdJobOpening = interviewService.findAll();
        return createdJobOpening != null ? ResponseEntity.status(OK)
                .body(createdJobOpening)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @PostMapping("/")
    public ResponseEntity<Interview> scheduleInterview(@RequestBody  Interview interview){
        Interview createdJobOpening = interviewService.scheduleInterview(interview);
        return createdJobOpening != null ? ResponseEntity.status(OK)
                .body(createdJobOpening)
                :ResponseEntity.status(FORBIDDEN)
                .body(null);
    }

}
