package com.StudentLance.demo.ServiceInterface;

import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.Interview;
import com.StudentLance.demo.Entity.JobOpening;

import java.util.List;

public interface CompanyServiceInt {

    Company findByCompanyRef(String companyRef);

    List<Company> findAll();

    Company findByCompanyEmail(String email);

    Company createCompany(Company company);

    Company updateCompany(Company company);

    Company login(String email, String password);


    }

