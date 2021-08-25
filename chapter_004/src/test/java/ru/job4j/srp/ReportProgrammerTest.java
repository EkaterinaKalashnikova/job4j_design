package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Calendar;


@Ignore
public class ReportProgrammerTest {

    @Test
    public void generate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report programmer = new ReportProgrammer(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                //.append(System.lineSeparator())
                .append("<").append(worker.getName()).append(">")
                .append("<").append(worker.getHired()).append(">")
                .append("<").append(worker.getFired()).append(">")
                .append("<").append(worker.getSalary()).append(">")
                .append(System.lineSeparator());
        assertThat(programmer.generate(em -> true), is(expect.toString()));
    }
}