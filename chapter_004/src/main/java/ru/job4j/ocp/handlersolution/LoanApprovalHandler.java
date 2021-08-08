package ru.job4j.ocp.handlersolution;

public class LoanApprovalHandler {
    /** @noinspection checkstyle:EmptyBlock*/
    public void approveLoan(Validator validator) {
        if (!validator.isValid()) {
            return;
        }
        // process the loan
    }
}
