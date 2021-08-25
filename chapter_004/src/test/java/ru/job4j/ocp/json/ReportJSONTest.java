package ru.job4j.ocp.json;

import com.google.gson.Gson;
import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.srp.Employee;
import ru.job4j.srp.MemStore;
import ru.job4j.srp.Report;
import ru.job4j.srp.ReportEngine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

@Ignore
public class ReportJSONTest {

    @Test
    public void whenGeneratedToJson() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Maria", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report json = new ReportJSON(store);
        List<Employee> listEmpl = Arrays.asList(worker1, worker2);
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Employee worker : listEmpl) {
            String str = String.format("{\"name\":\"%s\","
                           + "\"hired\":{\"year\":%s,\"month\":%s,\"dayOfMonth\":%s,\"hourOfDay\":%s,\"minute\":%s,\"second\":%s},"
                           + "\"fired\":{\"year\":%s,\"month\":%s,\"dayOfMonth\":%s,\"hourOfDay\":%s,\"minute\":%s,\"second\":%s},"
                           + "\"salary\":%s}",
                    worker.getName(),
                    worker.getHired().get(Calendar.YEAR),
                    worker.getHired().get(Calendar.MONTH),
                    worker.getHired().get(Calendar.DAY_OF_MONTH),
                    worker.getHired().get(Calendar.HOUR_OF_DAY),
                    worker.getHired().get(Calendar.MINUTE),
                    worker.getHired().get(Calendar.SECOND),

                    worker.getFired().get(Calendar.YEAR),
                    worker.getFired().get(Calendar.MONTH),
                    worker.getFired().get(Calendar.DAY_OF_MONTH),
                    worker.getFired().get(Calendar.HOUR_OF_DAY),
                    worker.getFired().get(Calendar.MINUTE),
                    worker.getFired().get(Calendar.SECOND),
                    worker.getSalary());
            sb.append(str);
            sb.append(",");
        }
        sb.delete(sb.lastIndexOf(","), sb.length());
        sb.append("]");

        assertThat(json.generate(em -> true), is(sb.toString()));
    }
}
