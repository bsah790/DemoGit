package guru.springframework.employee.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.employee.web.model.Employee;
import guru.springframework.employee.web.repository.EmployeeRepository;
import guru.springframework.employee.web.service.EmployeeService;
import guru.springframework.employee.web.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers=EmployeeController.class)
class EmployeeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private EmployeeService service;
    @MockBean
    private EmployeeRepository repository;
    @Autowired
    ObjectMapper mapper;
    @Test
    void getAllEmployeeTest() throws Exception {
        mockMvc.perform(get("/api/v1/employee"+"/allEmpInfo").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void getEmployeeByIdTest() throws Exception {
        mockMvc.perform(get("/api/v1/employee"+"/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createEmployeeTest() throws Exception {
        Employee emp = Employee.builder().empId(3).empName("Anik").address("Kolkata").salary(new BigDecimal(4500)).build();
        String str = mapper.writeValueAsString(emp);
        mockMvc.perform(post("/api/v1/employee/create").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(str)).andExpect(status().isCreated());
    }

    @Test
    void updateEmployeeByIdTest() throws Exception {
        mockMvc.perform(put("/api/v1/employee"+"/1/5900").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void updateEmployeeTest() throws Exception{
        Employee emp = Employee.builder().empName("Anik").address("Kolkata").salary(new BigDecimal(6050)).build();
        String str = mapper.writeValueAsString(emp);
        mockMvc.perform(put("/api/v1/employee/3").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(str)).andExpect(status().isOk());
    }

    @Test
    void deleteEmployeeByIdTest() throws Exception {
        mockMvc.perform(delete("/api/v1/employee"+"/3").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void deleteEmployeeTest() throws Exception {
       Employee emp = Employee.builder().empId(3).empName("Anik").address("Kolkata").salary(new BigDecimal(6050)).build();
        String str = mapper.writeValueAsString(emp);
        mockMvc.perform(delete("/api/v1/employee/delete").accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(str)).andExpect(status().isOk());
    }
}