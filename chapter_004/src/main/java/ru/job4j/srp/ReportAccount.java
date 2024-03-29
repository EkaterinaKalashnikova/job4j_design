package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportAccount implements Report {
    private Store store;

    public ReportAccount(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary");
        for (Employee employee : store.findBy(filter)) {
            int rub = (int) employee.getSalary();
            int evro = rub * 87;
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
