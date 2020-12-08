package com.StudentLance.demo.Services;

import com.StudentLance.demo.DAO.CompanyDAO;
import com.StudentLance.demo.DAO.InterviewDAO;
import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Entity.JobOpening;
import com.StudentLance.demo.ServiceInterface.CompanyServiceInt;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.beans.ExceptionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class CompanyService implements CompanyServiceInt {

    @Autowired
    private CompanyDAO companyDao;

    @Override
    public Company findByCompanyRef(String companyRef){
        return companyDao.findByCompanyRef(companyRef);
    }

    @Override
    public Company findByCompanyEmail(String email){
        return companyDao.findByCompanyEmail(email);
    }

    @Override
    public List<Company> findAll(){
        return companyDao.findAll();
    }

    @Override
    public Company createCompany(Company company)  {
        try {
            Company foundedCompanyByRef = companyDao.findByCompanyRef(company.getCompanyRef());
            Company foundedCompanyEmail = companyDao.findByCompanyEmail(company.getCompanyEmail());
        if (foundedCompanyByRef != null ) throw new Exception("Company Reference already exist!:  "+ company.getCompanyRef());
        else if (foundedCompanyEmail != null ) throw new Exception("Company Email already exist!:  " + company.getCompanyEmail());

        }catch (Exception e){
            System.out.println("Creating company failed");
        }
        return companyDao.save(company);
    }

    @Override
    public Company updateCompany(Company company){

        try {
            Company foundedCompanyByRef = companyDao.findByCompanyRef(company.getCompanyRef());
            Company foundedCompanyEmail = companyDao.findByCompanyEmail(company.getCompanyEmail());
            if (foundedCompanyByRef == null ) throw new Exception("Company Reference doesn't exist!:  "+ company.getCompanyRef());
            else if (foundedCompanyEmail != null ) throw new Exception("Company Email already exist!:  " + company.getCompanyEmail());

        }catch (Exception e){
            System.out.println("Updating company failed");
        }
        return companyDao.save(company);

    }

    @Override
    public Company login(String email, String password) {
        Company foundedEmail = companyDao.findByCompanyEmail(email);
        try {
            if (foundedEmail != null) throw new Exception("Company Email doesn't exist, Email  :" + email);
            if (!foundedEmail.getPassword().equals(password)) throw new Exception("Password and Email don't match  " );

        }catch (Exception e){
            System.out.println("failed to LogIn ");
        }
        return foundedEmail;
    }

}


