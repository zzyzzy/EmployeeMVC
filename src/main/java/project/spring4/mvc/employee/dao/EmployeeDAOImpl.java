package project.spring4.mvc.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import project.spring4.mvc.employee.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("empdao")
public class EmployeeDAOImpl implements EmployeeDAO {

    private JdbcTemplate jdbcTemplate;

    @Value("#{jdbc['insertSQL']}") private String insertSQL;
    @Value("#{jdbc['selectSQL']}") private String selectSQL;
    @Value("#{jdbc['selectOneSQL']}") private String selectOneSQL;
    @Value("#{jdbc['updateSQL']}") private String updateSQL;
    @Value("#{jdbc['deleteSQL']}") private String deleteSQL;

    @Autowired
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertEmployee(Employee e) {
        Object[] params = new Object[] { e.getEmpid(), e.getFname(), e.getLname(),
            e.getEmail(), e.getPhone(), e.getHdate(), e.getJobid(), e.getSal(),
            e.getComm(), e.getMgrid(), e.getDeptid() };

        return jdbcTemplate.update(insertSQL, params);
    }

    @Override
    public List<Employee> selectEmployee() {
        RowMapper<Employee> mapper = new EmployeeMapper();

        return jdbcTemplate.query(selectSQL, mapper);
    }

    private class EmployeeMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int num) throws SQLException {
            Employee emp = new Employee(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getInt(5));
            return emp;
        }
    }

    @Override
    public Employee selectOneEmployee(int empid) {
        Object[] param = new Object[] { empid };

        RowMapper<Employee> mapper = new EmployeeOneMapper();
        Employee emp =
            jdbcTemplate.queryForObject(selectOneSQL, mapper, empid);

        return emp;
    }

    private class EmployeeOneMapper implements RowMapper<Employee> {
        @Override
        public Employee mapRow(ResultSet rs, int num) throws SQLException {
            Employee emp = new Employee(rs.getInt(1), rs.getString(2),
                rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),
                rs.getString(7),rs.getInt(8),rs.getDouble(9),
                rs.getInt(10),rs.getInt(11) );

            return emp;
        }
    }

    @Override
    public int updateEmployee(Employee emp) {
        return 0;
    }

    @Override
    public int deleteEmployee(int empid) {
        Object[] param = new Object[] { empid };

        return jdbcTemplate.update(deleteSQL, param);
    }

}
