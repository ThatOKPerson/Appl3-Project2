package org.kainos.ea.core;

import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.DeliveryEmployeeRequest;

public class DeliveryEmployeeValidator {

    public String isValidDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) {

        if (deliveryEmployee.getName().length() > 70) {
            return "Name greater than 70 characters";
        }

        if (deliveryEmployee.getSalary() < 1) {
            return "Salary less than 1";
        }
        if (deliveryEmployee.getBankAcc().length() == 16) {
            return "Bank account number should be 16 characters";
        }
        if (deliveryEmployee.getNiNumber().length() == 9) {
            return "National insurance number must be 9 characters";
        }
        return null;

    }
}

