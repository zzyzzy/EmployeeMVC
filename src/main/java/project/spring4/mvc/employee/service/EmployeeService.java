package project.spring4.mvc.employee.service;

import project.spring4.mvc.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    boolean newEmployee(Employee emp);
    List<Employee> readEmployee();
    Employee readOneEmployee(int empid);
    boolean modifyEmployee(Employee emp);
    boolean removeEmployee(int empid);

}
