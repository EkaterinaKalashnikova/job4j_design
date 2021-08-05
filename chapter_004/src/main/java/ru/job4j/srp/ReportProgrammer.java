package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportProgrammer implements Report {
    private Store store;

    public ReportProgrammer(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary");
        for (Employee employee : store.findBy(filter)) {
            text.append("<").append(employee.getName()).append(">")
                    .append("<").append(employee.getHired()).append(">")
                    .append("<") .append(employee.getFired()).append(">")
                    .append("<").append(employee.getSalary()).append(">")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
