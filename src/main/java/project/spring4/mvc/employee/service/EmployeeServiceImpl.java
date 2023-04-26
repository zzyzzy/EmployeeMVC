package project.spring4.mvc.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.spring4.mvc.employee.dao.EmployeeDAO;
import project.spring4.mvc.employee.model.Employee;

import java.util.List;

@Service("empsrv")
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO empdao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO empdao) {
        this.empdao = empdao;
    }

    @Override
    public int newEmployee(Employee emp) {
        return 0;
    }

    @Override
    public List<Employee> readEmployee() {

        return empdao.selectEmployee();
    }

    @Override
    public Employee readOneEmployee(int empid) {
        return null;
    }

    @Override
    public int modifyEmployee(Employee emp) {
        return 0;
    }

    @Override
    public int removeEmployee(int empid) {
        return 0;
    }
}
