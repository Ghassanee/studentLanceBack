package com.StudentLance.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobOpening {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int jobId;
        private int companyId;
        private String title;
        private String description;
        private String responsibilities;
        private String location;
        private int salary;
        private String companyname;
        private String status;

        public JobOpening() {
        }
public JobOpening(int companyId,String companyname, String title, String description, String responsibilities, String location, int salary,  String status) {
        this.companyId = companyId;
        this.title = title;
        this.description = description;
        this.responsibilities = responsibilities;
        this.location = location;
        this.salary = salary;
        this.companyname = companyname;
        this.status = status;
    }
    public JobOpening(Integer companyId,String companyname, String title, String description, String responsibilities, String location, int salary) {
        this.companyId = companyId;
        this.title = title;
        this.description = description;
        this.responsibilities = responsibilities;
        this.location = location;
        this.salary = salary;
        this.companyname = companyname;
    }
    public int getJobId() {
            return jobId;
        }

        public void setJobId(int jobId) {
            this.jobId = jobId;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getResponsibilities() {
            return responsibilities;
        }

        public void setResponsibilities(String responsibilities) {
            this.responsibilities = responsibilities;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public String getCompanyname() {
            return companyname;
        }

        public void setCompanyname(String companyname) {
            this.companyname = companyname;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    }

