package com.StudentLance.demo.Services;


import com.StudentLance.demo.DAO.CompanyDAO;
import com.StudentLance.demo.DAO.JobOpeningDAO;
import com.StudentLance.demo.DAO.JobOpening_UserDAO;
import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.Entity.JobOpening_User;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Service
public class JobOpeningService {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JobOpeningDAO jobOpeningDao;
    @Autowired
    private JobOpening_UserDAO jobOpening_userDAO ;
    @Autowired
    private CompanyDAO companyDao;

    public JobOpeningService() {

    }

    public JobOpeningService(JobOpeningDAO jobopeningDao) {
        this.jobOpeningDao = jobOpeningDao;
    }

    public Optional<JobOpening> getJobOpening(int jobId) {

        JobOpening jobOpening = null;
        return jobOpeningDao.findById((long) jobId);
    }


    public JobOpening createJobOpening(Company company, String title, String description,
                                       String responsibilities, String location, String salary)
    {

        JobOpening jobOpening;
        try {
            jobOpening = new JobOpening(Integer.valueOf(company.getCompanyId()), company.getCompanyname(),
                    title, description, responsibilities, location, Integer.valueOf(salary));
            JobOpening newJobOpening = jobOpeningDao.save(jobOpening);
            return newJobOpening;
        } catch (Exception e)
        {
            return null;
        }
    }

    
    public List<JobOpening> getJobOpeningsInCompany(String companyId)
    {
        String query = "select * from job_openings where job_openings.companyId = " + companyId;
        List<JobOpening> jobOpeningList = new ArrayList<>();
        jobOpeningList = jobOpeningDao.findJobOpeningsInCompany(companyId);
        return jobOpeningList;
    }

    public List<JobOpening> getJobOpeningsInCompany(String companyId, List<String> statuslist)
    {
        List<JobOpening> jobOpeningList = new ArrayList<>();
        jobOpeningList = jobOpeningDao.findJobOpeningsInCompanyByStatus(companyId, statuslist);
        return jobOpeningList;
    }


    public JobOpening getJobOpeningByJobId(String jobId)
    {
        JobOpening jobOpening = jobOpeningDao.findJobOpeningByJobId(Integer.valueOf(jobId));
        return jobOpening;
    }

    public String getJobOpeningsByFilters(String companynames, String locations,
                                          String salaryStart, String salaryEnd)
    {
        List<JobOpening> jobOpenings = new ArrayList<>();
        List<Integer> jobIds = new ArrayList<>();
        List<Integer> companiesList = new ArrayList<>();
        List<Integer> locationsList = new ArrayList<>();
        List<Integer> salaryList = new ArrayList<>();

        //Check if company list is present
        if (!companynames.equals("")) {
            List<String> companynamesList = Arrays.asList(companynames.split("\\s*,\\s*"));
            companiesList = jobOpeningDao.findJobOpeningsInCompanyByName(companynamesList);
        }
        if (!locations.equals("")) {
            List<String> locationNamesList = Arrays.asList(locations.split("\\s*,\\s*"));
            locationsList = jobOpeningDao.
                    findJobOpeningsInCompanyByLocation(locationNamesList);
        }
        if (!(salaryStart.equals("") && salaryEnd.equals("")))
        {
            salaryList = jobOpeningDao.findJobOpeningsInCompanyBySalary
                    (Integer.valueOf(salaryStart), Integer.valueOf(salaryEnd));
        }

        Collection<Integer> collection1 = companiesList;
        Collection<Integer> collection2 = locationsList;
        Collection<Integer> collection3 = salaryList;
        Collection<Integer> Intersection = new ArrayList<Integer>();
        if (!companiesList.isEmpty() && !locationsList.isEmpty()) {
            Intersection = (Collection<Integer>) CollectionUtils.intersection(collection1, collection2);
        } else if (!companiesList.isEmpty() && locations.equals("")) {
            Intersection = companiesList;
        } else if (!locationsList.isEmpty() && companynames.equals("")) {
            Intersection = locationsList;
        }

        if (!salaryStart.equals("")) {
            if (companynames.equals("") && locations.equals("")) {
                Intersection = salaryList;
            } else {
                Intersection = (Collection<Integer>)CollectionUtils.intersection(Intersection, collection3);
            }

        }
        jobIds.addAll(Intersection);
        if (!jobIds.isEmpty()) {
            jobOpenings = jobOpeningDao.findJobOpeningsInCompanyByFilter(jobIds);
        }

        List<Object> l = new ArrayList<>();

        for(int i = 0 ; i < jobOpenings.size(); i++){
            ModelMap m = new ModelMap();
            m.addAttribute("jobId", jobOpenings.get(i).getJobId());
            m.addAttribute("companyId", jobOpenings.get(i).getCompanyId());
            m.addAttribute("title", jobOpenings.get(i).getTitle());
            m.addAttribute("description", jobOpenings.get(i).getDescription());
            m.addAttribute("responsibilities", jobOpenings.get(i).getResponsibilities());
            m.addAttribute("location", jobOpenings.get(i).getLocation());
            m.addAttribute("salary", jobOpenings.get(i).getSalary());
            m.addAttribute("companyname", jobOpenings.get(i).getCompanyname());
            m.addAttribute("status", jobOpenings.get(i).getCompanyname());
            m.addAttribute("URL", (companyDao.findByCompanyId(jobOpenings.get(i).getCompanyId())).getLogo_image_URL());
            l.add(m);
        }

        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        map.put("jobopenings", l);

        Gson gson = new Gson();
        String jobOpeningsJson = gson.toJson(map, LinkedHashMap.class);
        return jobOpeningsJson;
    }


    public Object getAllOpenJobs() {
        List<JobOpening> jobOpeningList = new ArrayList<>();
        jobOpeningList = jobOpeningDao.getAllJobs();
        List<Object> l = new ArrayList<>();

        for(int i = 0 ; i < jobOpeningList.size(); i++){
            ModelMap m = new ModelMap();
            m.addAttribute("jobId", jobOpeningList.get(i).getJobId());
            m.addAttribute("companyId", jobOpeningList.get(i).getCompanyId());
            m.addAttribute("title", jobOpeningList.get(i).getTitle());
            m.addAttribute("description", jobOpeningList.get(i).getDescription());
            m.addAttribute("responsibilities", jobOpeningList.get(i).getResponsibilities());
            m.addAttribute("location", jobOpeningList.get(i).getLocation());
            m.addAttribute("salary", jobOpeningList.get(i).getSalary());
            m.addAttribute("companyname", jobOpeningList.get(i).getCompanyname());
            m.addAttribute("status", jobOpeningList.get(i).getCompanyname());
            m.addAttribute("URL", (companyDao.findByCompanyId(jobOpeningList.get(i).getCompanyId())).getLogo_image_URL());
            l.add(m);

        }

        return l;
    }

    public ModelMap getAllFilters() {
        List<String> companyList = new ArrayList<>();
        companyList = companyDao.getAllCompanies();

        List<String> locationList = new ArrayList<>();
        locationList = jobOpeningDao.getAllLocations();

        ModelMap m = new ModelMap();
        m.addAttribute("companies", companyList);
        m.addAttribute("locations", locationList);

        return m;
    }



    public ResponseEntity updateJob(int jobid, String emails, int companyId, String companyname, String title, String description,
                                    String responsibilities, String location, int salary, String status) {

        JobOpening jobOpening = jobOpeningDao.findJobOpeningByJobId(jobid);

        if (jobOpening == null) {
            //todo : jobopening not found

            ModelMap m = new ModelMap();
            m.addAttribute("msg", "job opening not exists");

            return new ResponseEntity(jobOpening, HttpStatus.BAD_REQUEST);
        }
        try {

            jobOpening = new JobOpening(companyId, companyname, title, description, responsibilities,
                    location, salary, status);


            jobOpening.setJobId(jobid);
            jobOpening = jobOpeningDao.save(jobOpening);


            return new ResponseEntity(jobOpening, HttpStatus.OK);

        } catch(Exception ex) {
            //TODO : Handle exception
            throw new RuntimeException();
        }


    }

    public ResponseEntity updateJobOpening(int jobid, String status){

        try {
            List<JobOpening_User> offerJobs = jobOpening_userDAO.getOfferJobs(jobid);

        if (status.equals("Cancelled")) {

                if (offerJobs.size() == 0) {

                    JobOpening job = jobOpeningDao.findByJobId(jobid);
                    job.setStatus(status);
                    jobOpeningDao.save(job);

                    //update non-terminal applications
                    List<JobOpening_User> nonTerminalApplications = jobOpening_userDAO.getNonTerminalApplications(jobid);
                    for (int i = 0; i < nonTerminalApplications.size(); i++) {
                        nonTerminalApplications.get(i).setStatus("Cancelled by Company");
                        nonTerminalApplications.get(i).setInterested(false);
                        jobOpening_userDAO.save(nonTerminalApplications.get(i));
                    }

                    ModelMap m = new ModelMap();
                    m.addAttribute("code", 200);
                    m.addAttribute("msg", "Successfully updated");
                    return new ResponseEntity(m, HttpStatus.OK);

                } else {
                    ModelMap m = new ModelMap();
                    m.addAttribute("code", 400);
                    m.addAttribute("msg", "Job has one or more applications in offer accepted state");
                    return new ResponseEntity(m, HttpStatus.BAD_REQUEST);
                }

            } else if (status.equals("Filled")) {

                if (offerJobs.size() > 0) {

                    JobOpening job = jobOpeningDao.findByJobId(jobid);
                    job.setStatus(status);
                    jobOpeningDao.save(job);

                    //update non-terminal applications
                    List<JobOpening_User> nonTerminalApplications = jobOpening_userDAO.getNonTerminalApplications(jobid);
                    for (int i = 0; i < nonTerminalApplications.size(); i++) {
                        nonTerminalApplications.get(i).setStatus("Cancelled by Company");
                        nonTerminalApplications.get(i).setInterested(false);
                        jobOpening_userDAO.save(nonTerminalApplications.get(i));
                    }

                    ModelMap m = new ModelMap();
                    m.addAttribute("code", 200);
                    m.addAttribute("msg", "Successfully updated");
                    return new ResponseEntity(m, HttpStatus.OK);
                }
                else {
                    ModelMap m = new ModelMap();
                    m.addAttribute("code", 400);
                    m.addAttribute("msg", "Job has no application in offer accepted state");
                    return new ResponseEntity(m, HttpStatus.BAD_REQUEST);
                }

            } else {
                ModelMap m = new ModelMap();
                m.addAttribute("code", 400);
                m.addAttribute("msg", "Invalid update");
                return new ResponseEntity(m, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            ModelMap m = new ModelMap();
            m.addAttribute("code", 400);
            m.addAttribute("msg", "Error catch");
            return new ResponseEntity(m, HttpStatus.BAD_REQUEST);
        }
    }

}



