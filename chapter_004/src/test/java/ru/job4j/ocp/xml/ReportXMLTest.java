package ru.job4j.ocp.xml;

import org.junit.Test;
import ru.job4j.srp.Employee;
import ru.job4j.srp.MemStore;
import ru.job4j.srp.Report;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportXMLTest {

    @Test
    public void whenGeneratedToXml() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Maria", now, now, 200);
        store.add(worker1);
        store.add(worker2);
        Report xml = new ReportXML(store);
        List<Employee> listEmpl = Arrays.asList(worker1, worker2);
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
        sb.append("\n");
        sb.append("<employees>");
        sb.append("\n");
        DateFormat time = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        for (Employee worker : listEmpl) {
            String str = String.format("  <ells> \n"
                            + "        <fired>%s</fired>\n"
                            + "        <hired>%s</hired>\n"
                            + "        <name>%s</name>\n"
                            + "        <salary>%s</salary>\n"
                            + "    </ells>",

                    time.format(worker.getFired().getTime()),
//                    worker.getFired().get(Calendar.MONTH),
//                    worker.getFired().get(Calendar.DAY_OF_MONTH),
//                    worker.getFired().get(Calendar.HOUR_OF_DAY),
//                    worker.getFired().get(Calendar.MINUTE),
//                    worker.getFired().get(Calendar.SECOND),

                    time.format(worker.getHired().getTime()),
//                    worker.getHired().get(Calendar.MONTH),
//                    worker.getHired().get(Calendar.DAY_OF_MONTH),
//                    worker.getHired().get(Calendar.HOUR_OF_DAY),
//                    worker.getHired().get(Calendar.MINUTE),
//                    worker.getHired().get(Calendar.SECOND),

                    worker.getName(),
                    worker.getSalary());
            sb.append(str);
            sb.append("\n");
        }
        sb.append("</employees>");
        sb.append("\n");
        assertThat(xml.generate(em -> true).replaceAll(" ", ""), is(sb.toString().replaceAll(" ", "")));
    }
}