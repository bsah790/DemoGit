package guru.springframework.employee.web.service;

import guru.springframework.employee.web.model.Employee;
import guru.springframework.employee.web.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>)repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer empId) {
        return repository.findById(empId).get();
    }

    @Override
    public Employee createEmployee(Employee emp) {

        return repository.save(emp);
    }

    @Override
    public Employee updateEmployeeById(Integer empId, BigDecimal salary) {
        Employee emp = repository.findById(empId).get();
        emp.setSalary(salary);
        repository.save(emp);
        return emp;
    }

    @Override
    public Employee updateEmployee(Integer empId, Employee emp) {
        Employee updatedEmp = repository.findById(empId).get();
        updatedEmp.setEmpName(emp.getEmpName());
        updatedEmp.setSalary(emp.getSalary());
        updatedEmp.setAddress(emp.getAddress());
        repository.save(updatedEmp);
        return updatedEmp;
    }

    @Override
    public void deleteEmployeeById(Integer empId) {
        repository.deleteById(empId);
    }

    @Override
    public void deleteEmployee(Employee emp) {
        repository.delete(emp);
    }
}
