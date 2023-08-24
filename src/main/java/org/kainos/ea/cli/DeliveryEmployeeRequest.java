package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class DeliveryEmployeeRequest {
    private String name;
    private Double salary;
    private String bankAcc;
    private String niNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getBankAcc() {
        return bankAcc;
    }

    public void setBankAcc(String bankAcc) {
        this.bankAcc = bankAcc;
    }

    public String getNiNumber() {
        return niNumber;
    }

    public void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }

    @JsonCreator
    public DeliveryEmployeeRequest(
            @JsonProperty("name") String name,
            @JsonProperty("salary") Double salary,
            @JsonProperty("bankAccount") String bankAcc,
            @JsonProperty("NationalInsuranceNumber") String niNumber){
        this.name = name;
        this.salary = salary;
        this.bankAcc = bankAcc;
        this.niNumber = niNumber;
    }
}
