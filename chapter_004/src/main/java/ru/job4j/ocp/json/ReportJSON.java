package ru.job4j.ocp.json;

import com.google.gson.GsonBuilder;
import ru.job4j.srp.Employee;
import ru.job4j.srp.Report;
import ru.job4j.srp.Store;

import java.util.List;
import java.util.function.Predicate;

public class ReportJSON  implements Report {
    private Store store;

    public ReportJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary");
        List<Employee> empl =  store.findBy(filter);
        var lib = new GsonBuilder().create();
        String json = lib.toJson(empl);
        System.out.println(json);
        return json;
    }
}
