package org.kainos.ea.cli;

public class DeliveryEmployee {
    private int employeeId;
    private String name;
    private Double salary;
    private String bankAcc;
    private String niNumber;

    public DeliveryEmployee(int employeeId, String name, Double salary, String bankAcc, String niNumber) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.bankAcc = bankAcc;
        this.niNumber = niNumber;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

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
}
