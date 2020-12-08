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

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/StudentLance/Company")
@Api("CR")
public class CompanyRest {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private JobOpeningService jobOpeningService;

    @Autowired
    private UserService userService;
    
    @GetMapping("/")
    public ResponseEntity<List<Company>> findAll(){
        return ResponseEntity.status(OK)
                .body(companyService.findAll());
    }

    @GetMapping("/{companyRef}")
    public ResponseEntity<Company> findByCompanyRef(@PathVariable("companyRef") String companyRef){
        return ResponseEntity.status(OK)
                .body(companyService.findByCompanyRef(companyRef));
    }

    @GetMapping("/{email}")
    public  ResponseEntity<Company>  findByCompanyEmail(@PathVariable("email") String email){
        return ResponseEntity.status(OK)
                .body(companyService.findByCompanyEmail(email));
    }

    @PostMapping("/")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return ResponseEntity.status(OK)
                .body(companyService.createCompany(company));
    }

    @PutMapping("/update")
    public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
        return ResponseEntity.status(OK)
                .body(companyService.updateCompany(company));
    }

    @GetMapping("/company/login/{email}/{password}")
    public ResponseEntity<Company> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        return ResponseEntity.status(OK)
                .body(companyService.login(email, password));
    }


}
