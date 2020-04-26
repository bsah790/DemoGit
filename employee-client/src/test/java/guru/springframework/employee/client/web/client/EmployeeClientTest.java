package guru.springframework.employee.client.web.client;

import guru.springframework.employee.client.web.model.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.net.URI;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class EmployeeClientTest {

    @Autowired
    EmployeeClient employeeClient;

    @Test
    void getAllEmployeeInfoTest() {
        List<Employee> list = employeeClient.getAllEmployeeInfo();
       assertTrue(list.size() > 0);
    }

    @Test
    void getEmployeeInfoByIdTest() {
        Employee emp = employeeClient.getEmployeeInfoById(1);
        assertEquals(emp.getEmpName(),"Ram");
    }

    @Test
    void saveEmployeeInfoTest() {
        Employee emp = Employee.builder().empName("Shahil").address("Bangaluru").salary(new BigDecimal(5700)).build();
        URI uri = employeeClient.saveEmployeeInfo(emp);
        assertNotNull(uri);
    }

    @Test
    void updateEmployeeByIdTest() {
        employeeClient.updateEmployeeById(5, new BigDecimal(6800));
        Employee emp =  employeeClient.getEmployeeInfoById(5);
        assertEquals(emp.getSalary(), new BigDecimal(6800.00).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

    @Test
    void updateEmployeeTest() {
        Employee emp = Employee.builder().empName("Arun").address("Bangkok").salary(new BigDecimal(7600)).build();
        employeeClient.updateEmployee(2, emp);
        Employee updatedEmp =  employeeClient.getEmployeeInfoById(2);
        assertEquals(updatedEmp.getSalary(), new BigDecimal(7600).setScale(2, BigDecimal.ROUND_HALF_UP));
        assertEquals(updatedEmp.getEmpName(), "Arun");
        assertEquals(updatedEmp.getAddress(), "Bangkok");
    }

    @Test
    void deleteEmployeeByIdTest(){
        int count = employeeClient.getAllEmployeeInfo().size();
        employeeClient.deleteEmployeeById(3);
        assertEquals(employeeClient.getAllEmployeeInfo().size(), count-1);
    }

    @Test
    void deleteEmployeeTest() throws Exception {
        int count = employeeClient.getAllEmployeeInfo().size();
        Employee emp = Employee.builder().empId(4).empName("Abhishek").address("Naktala").salary(new BigDecimal(15000)).build();
        ResponseEntity responseEntity = employeeClient.deleteEmployee(emp);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
        assertEquals(employeeClient.getAllEmployeeInfo().size(), count-1);
    }
}