package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CompanyDAO extends JpaRepository<Company,Long> {

    public Company findByCompanyId(int companyId);

    public Company findByCompanyemail(String companyemail);

    @Query(value = "select distinct companyname from studentlance.company", nativeQuery = true)
    List<String> getAllCompanies();



}
