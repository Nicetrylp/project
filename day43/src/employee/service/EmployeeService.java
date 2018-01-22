package employee.service;

import employee.bean.Employee;
import employee.dao.EmployeeDao;

import java.util.List;

public class EmployeeService {
    private static EmployeeDao ed = new EmployeeDao();
    public void add(Employee employee) {
        ed.add(employee);
    }

    public List<Employee> show() {
        List<Employee> employees = ed.show();
        return employees;
    }

    public void update(Employee employee) {
        ed.update(employee);
    }
}
