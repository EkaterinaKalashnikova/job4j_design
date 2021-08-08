package ru.job4j.ocp.handler;

public class LoanApprovalHandler {
    public void approveLoan(PersonalLoanValidator validator) {
        validator.isValid();
        // Process of the loan
    }

    public void approveLoan(VehicleLoanValidator validator) {
        validator.isValid();
        // Process of the loan
    }
}

class PersonalLoanValidator {
    public boolean isValid() {
        // validation logic
        return true;
    }
}

class VehicleLoanValidator {
    public boolean isValid() {
        // validation logic
        return true;
    }
}