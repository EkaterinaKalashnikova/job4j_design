package ru.job4j.ocp.xml;

import ru.job4j.srp.Employee;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
public class Employees {

    private List<Employee> ells;

    public Employees() {
    }

    public Employees(List<Employee> ells) {
        this.ells = ells;
    }

    public List<Employee> getElls() {
        return ells;
    }

//    public void setEmpls(List<Employee> ells) {
//        this.ells = ells;
//    }
    public void setElls(List<Employee> ells) {
        this.ells = ells;
    }
}