package guru.springframework.employee.web.controller;

import guru.springframework.employee.web.model.Employee;
import guru.springframework.employee.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allEmpInfo")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") Integer empId){
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping("/create")
    public ResponseEntity createEmployee(@Valid @RequestBody Employee emp){
        Employee empObj = employeeService.createEmployee(emp);
        HttpHeaders header = new HttpHeaders();
        header.add("Location", "/api/v1/employee/create/" + emp.toString());
        return  new ResponseEntity(header, HttpStatus.CREATED);
    }

    @PutMapping("/{empId}/{salary}")
    public Employee updateEmployeeById(@PathVariable("empId") Integer empId, @PathVariable("salary") BigDecimal salary){
        return employeeService.updateEmployeeById(empId,salary);
    }

    @PutMapping("/{empId}")
    public Employee updateEmployee(@PathVariable("empId") Integer empId, @Valid @RequestBody Employee emp){
        return employeeService.updateEmployee(empId,emp);
    }

    @DeleteMapping("/{empId}")
    public void deleteEmployeeById(@PathVariable("empId") Integer empId){
        employeeService.deleteEmployeeById(empId);
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@Valid @RequestBody Employee emp){
        employeeService.deleteEmployee(emp);
    }
}
