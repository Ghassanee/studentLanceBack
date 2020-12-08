package com.StudentLance.demo.REST;


import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Services.InterviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/StudentLance/interview")
public class InterviewRest {

    @Autowired
    private InterviewService interviewService;


    @GetMapping("/status/{status}")
    public ResponseEntity<List<Interview>> findAllByStatus(@PathVariable("status") String status) {
        return ResponseEntity.status(OK)
                .body(interviewService.findAllByStatus(status));
    }

    @GetMapping("/{interviewRef}")
    public ResponseEntity<Interview> findByInterviewRef(@PathVariable("interviewRef") String interviewRef) {
        return ResponseEntity.status(OK)
                .body(interviewService.findByInterviewRef(interviewRef));
    }

    @GetMapping("/")
    public ResponseEntity<List<Interview>> findAll() {
        return ResponseEntity.status(OK)
                .body(interviewService.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Interview> scheduleInterview(@RequestBody  Interview interview){
        return ResponseEntity.status(OK)
                .body(interviewService.scheduleInterview(interview));
    }

}
