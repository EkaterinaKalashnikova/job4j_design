package ru.job4j.srp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ReportPersonal implements Report {
    private Store store;

    public ReportPersonal(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> listEmployees = new ArrayList<>(store.findBy(filter));
        listEmployees.sort(Comparator.comparing(Employee::getSalary));
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary");
        text.append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
//        List<String> list = new ArrayList<>();
//        list.add(text.toString());
        return text.toString();
    }
}
