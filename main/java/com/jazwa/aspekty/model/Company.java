package com.jazwa.aspekty.model;

public class Company {
    private Long employeeNumber;
    private Float yearIncome;
    private String headquarters;

    public Company() {
    }

    public Company(Long employeeNumber, Float yearIncome, String headquarters) {
        this.employeeNumber = employeeNumber;
        this.yearIncome = yearIncome;
        this.headquarters = headquarters;
    }

    public Long getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Long employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Float getYearIncome() {
        return yearIncome;
    }

    public void setYearIncome(Float yearIncome) {
        this.yearIncome = yearIncome;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public void setHeadquarters(String headquarters) {
        this.headquarters = headquarters;
    }
}
