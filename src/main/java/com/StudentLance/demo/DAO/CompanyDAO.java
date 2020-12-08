package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
@Repository
public interface CompanyDAO extends JpaRepository<Company,Long> {

    Company findByCompanyRef(String companyRef);

    List<Company> findAll();

    Company findByCompanyEmail(String email);

}
