package com.StudentLance.demo.REST;

import com.StudentLance.demo.Entity.Company;
import com.StudentLance.demo.Services.CompanyService;
import com.StudentLance.demo.Services.JobOpeningService;
import com.StudentLance.demo.Services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/StudentLance/Company")
@Api("CR")
public class CompanyRest {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/")
    public ResponseEntity<List<Company>> findAll(){
        List<Company> companyList = companyService.findAll();
        return companyList != null ? ResponseEntity.status(OK)
                .body(companyList)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/{companyRef}")
    public ResponseEntity<Company> findByCompanyRef(@PathVariable("companyRef") String companyRef){
        Company foundedCompany = companyService.findByCompanyRef(companyRef);
        return foundedCompany != null ? ResponseEntity.status(OK)
                .body(foundedCompany)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @GetMapping("/{email}")
    public  ResponseEntity<Company>  findByCompanyEmail(@PathVariable("email") String email){
        Company foundedCompany = companyService.findByCompanyEmail(email);
        return foundedCompany != null ? ResponseEntity.status(OK)
                .body(foundedCompany)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }

    @PostMapping("/")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company createdCompany = companyService.createCompany(company);
        return createdCompany != null ? ResponseEntity.status(OK)
                .body(createdCompany)
                :ResponseEntity.status(FORBIDDEN)
                .body(null);
    }

    @PutMapping("/update")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        Company updatedCompany= companyService.updateCompany(company);
        return updatedCompany != null ? ResponseEntity.status(OK)
                .body(updatedCompany)
                :ResponseEntity.status(FORBIDDEN)
                .body(null);
    }

    @GetMapping("/company/login/{email}/{password}")
    public ResponseEntity<Company> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        Company foundedCompany = companyService.login(email, password);
        return foundedCompany != null ? ResponseEntity.status(OK)
                .body(foundedCompany)
                :ResponseEntity.status(NOT_FOUND)
                .body(null);
    }


}
