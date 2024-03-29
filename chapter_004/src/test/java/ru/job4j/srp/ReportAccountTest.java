package ru.job4j.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Calendar;


@Ignore
public class ReportAccountTest {

    @Test
    public void generate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report account = new ReportAccount(store);
        int rub = (int) worker.getSalary();
        int evro = rub * 87;
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary")
                //.append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(account.generate(em -> true), is(expect.toString()));
    }
}