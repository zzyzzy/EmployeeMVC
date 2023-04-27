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
    public boolean newEmployee(Employee emp) {
        boolean result = false;

        if (empdao.insertEmployee(emp) > 0) result = true;

        return result;
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
    public boolean modifyEmployee(Employee emp) {
        return false;
    }

    @Override
    public boolean removeEmployee(int empid) {
        return false;
    }
}
