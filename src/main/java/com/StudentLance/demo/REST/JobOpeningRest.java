package com.StudentLance.demo.REST;


import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Services.CompanyService;
import com.StudentLance.demo.Services.JobOpeningService;
import com.StudentLance.demo.Services.JopOpeningUserService;
import com.StudentLance.demo.exception.HttpError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
@RequestMapping("/StudentLance/JobOpening")
public class JobOpeningRest {

        @Autowired
        private CompanyService companyService;

        @Autowired
        private JobOpeningService jobOpeningService;

        @Autowired
        private JopOpeningUserService jobOpeningUserService ;


        private final Logger log = LoggerFactory.getLogger(this.getClass());


        @PostMapping ("/jobopenings")
        public ResponseEntity createJobOpening(HttpServletResponse response,
                                               @RequestParam Map<String,String> params)
        {
            String companyId = params.get("companyId");

            if (companyId == null)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HttpError(404,
                        "Sorry the requested company with id " + companyId + " does not exist").
                        toString());
            }

            Company company = companyService.getCompany(Integer.valueOf(companyId));

            if (company == null)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HttpError(404,
                        "Sorry the requested company with id " + companyId + " does not exist").
                        toString());
            }

            String title = params.get("title");
            String description = params.get("description");
            String location = params.get("location");
            String salary = params.get("salary");
            String responsibilties = params.get("responsibilities");

            JobOpening jobopening = jobOpeningService.createJobOpening(company, title, description,
                    responsibilties, location, salary);
            if (jobopening == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new HttpError(500,
                        "Server error, please try again").toString());
            }
            return new ResponseEntity<>(companyService.getJobopeningInCompany(company,jobopening),
                    new HttpHeaders(), HttpStatus.OK);

        }

        @GetMapping("/company/{companyId}/jobopenings")
        public ResponseEntity getJobOpeningsInCompany( HttpServletResponse response,
                                                       @PathVariable String companyId,
                                                       @RequestParam Map<String, String> params)
        {
            Company company = companyService.getCompany(Integer.valueOf(companyId));

            if (company == null)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HttpError(404,
                        "Sorry the requested company with id " + companyId + " does not exist").
                        toString());
            }

            if (params.get("statuslists") != null) {
                String statuslists = params.get("statuslists");
                List<String> statusList= Arrays.asList(statuslists.split("\\s*,\\s*"));
                List<JobOpening> jobOpeningByStatusList = new ArrayList<>();
                jobOpeningByStatusList = jobOpeningService.
                        getJobOpeningsInCompany(companyId, statusList);

                return new ResponseEntity<>(companyService.getJobOpenings(company,
                        jobOpeningByStatusList), new HttpHeaders(), HttpStatus.OK);

            }
            List<JobOpening> jobOpeningList = new ArrayList<>();
            jobOpeningList = jobOpeningService.getJobOpeningsInCompany(companyId);
            return new ResponseEntity<>(companyService.getJobOpenings(company, jobOpeningList),
                    new HttpHeaders(), HttpStatus.OK);
        }

        @GetMapping ("/jobopenings/{jobId}")
        public ResponseEntity getJobOpening(HttpServletResponse response, @PathVariable String jobId)
        {
            JobOpening jobOpening = jobOpeningService.getJobOpeningByJobId(jobId);
            if (jobOpening == null)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HttpError(404,
                        "Sorry the requested opening with id " + jobId + " does not exist").
                        toString());
            }
            Company company = companyService.getCompany(jobOpening.getCompanyId());
            return new ResponseEntity<>(companyService.getJobopeningInCompany(company, jobOpening),
                    new HttpHeaders(), HttpStatus.OK);

        }

        @GetMapping ("/jobopenings")
        public ResponseEntity getJobOpeningsInCompany( HttpServletResponse response,
                                                       @RequestParam Map<String, String> params)
        {
            String companynames = "";
            String locations = "";
            String salaryStart = "";
            String salaryEnd = "";

            //check if company name is present in search
            if (params.get("companynames") != null) {
                companynames = params.get("companynames");
            }

            //check if location is present in search
            if (params.get("locations") != null) {
                locations = params.get("locations");

            }

            //check if salary range is present
            if (params.get("salary") != null) {
                salaryStart = params.get("gt");
                salaryEnd = params.get("lt");
            }

            List<JobOpening> jobOpenings = new ArrayList<>();
            return new ResponseEntity<>(jobOpeningService.getJobOpeningsByFilters(companynames,
                    locations, salaryStart, salaryEnd), new HttpHeaders(),
                    HttpStatus.OK);

        }

        @GetMapping("/user/jobs")
        public ResponseEntity getAllOpenJobs()
        {
            return new ResponseEntity(jobOpeningService.getAllOpenJobs(), HttpStatus.OK);
        }


        @GetMapping ("/filters")
        public ResponseEntity getFilters()
        {
            return new ResponseEntity(jobOpeningService.getAllFilters(), HttpStatus.OK);
        }

        @PutMapping("/jobopening/{jobid}")
        public ResponseEntity updateJobOpening(HttpServletResponse response, @PathVariable String jobid,
                                               @RequestParam Map<String,String> params)
        {

            int jobId = Integer.valueOf(jobid);
            Optional<JobOpening> jobOpening = jobOpeningService.getJobOpening(jobId);

            if (null == jobOpening) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new HttpError(404,
                        "Sorry the requested job with id " + jobId + " does not exist").
                        toString());
            }
            String description = params.get("description") == null ?
                    jobOpening.get().getDescription() : params.get("description");

            String location = params.get("location") == null ?
                    jobOpening.get().getLocation() : params.get("location");

            String responsibilities = params.get("responsibilities") == null ?
                    jobOpening.get().getResponsibilities(): params.get("responsibilities");

            int salary = params.get("salary") == null ?
                    jobOpening.get().getSalary() : Integer.valueOf(params.get("salary"));

            String status = params.get("status") == null ?
                    jobOpening.get().getStatus() : params.get("status");

            String title = params.get("title") == null ?
                    jobOpening.get().getTitle() : params.get("title");

            int companyId = jobOpening.get().getCompanyId();
            String companyname = jobOpening.get().getCompanyname();

            String emailList = jobOpeningUserService.getActiveCompanyApplications(jobId);
            return jobOpeningService.updateJob(jobId, emailList, companyId, companyname, title, description,
                    responsibilities, location, salary, status);
        }

        @PostMapping("/jobopenings/updateJobOpening")
        public ResponseEntity updateJobOpening(@RequestParam(value="jobid") String jobid,
                                               @RequestParam(value="status") String status)
        {
            return jobOpeningService.updateJobOpening(Integer.valueOf(jobid), status);
        }

    }


