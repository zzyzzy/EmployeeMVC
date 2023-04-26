package project.spring4.mvc.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import project.spring4.mvc.employee.model.Employee;

import java.util.List;

@Repository("empdao")
public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertEmployee(Employee emp) {
        return 0;
    }

    @Override
    public List<Employee> selectEmployee() {
        return null;
    }

    @Override
    public Employee selectOneEmployee(int empid) {
        return null;
    }

    @Override
    public int updateEmployee(Employee emp) {
        return 0;
    }

    @Override
    public int deleteEmployee(int empid) {
        return 0;
    }
}
