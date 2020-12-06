package com.StudentLance.demo.DAO;

import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Entity.JobOpening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;
@Repository
public interface CompanyDAO extends JpaRepository<Company,int> {

    public Company findByCompanyId(int  companyId);
    public List<Company> findAll();

    public Company findByCompanyemail(String companyemail);

    @Query("select distinct c.companyname from Company c")
    List<String> getAllCompanies();

    


}
