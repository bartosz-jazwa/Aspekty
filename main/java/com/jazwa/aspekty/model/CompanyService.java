package com.jazwa.aspekty.model;

import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    Company company = new Company(2L,3.21f,"Rzeszów");

    public Long getCompanyEmployeeNumber(){
        return company.getEmployeeNumber();
    }

    public Float getCompanyYearIncome(){
        return company.getYearIncome();
    }

    public String getCompanyHeadquarters(){
        return company.getHeadquarters();
    }

}
