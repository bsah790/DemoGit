package guru.springframework.employee.web.service;

import guru.springframework.employee.web.model.Employee;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Integer empId);

    Employee createEmployee(Employee emp);

    Employee updateEmployeeById(Integer empId, BigDecimal salary);

    Employee updateEmployee(Integer empId, Employee emp);

    void deleteEmployeeById(Integer empId);

    void deleteEmployee(Employee emp);
}
