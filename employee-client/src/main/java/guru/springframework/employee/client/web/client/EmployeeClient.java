package guru.springframework.employee.client.web.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.employee.client.web.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(value = "employee.api", ignoreUnknownFields = false)
public class EmployeeClient {

    public final String EMPLOYEE_PATH_VI_END_POINT="/api/v1/employee/";
    private String host;

    @Autowired
    ObjectMapper mapper;

    private final RestTemplate restTemplate;

    EmployeeClient(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
    }

    public List<Employee> getAllEmployeeInfo(){
        return (List<Employee>)restTemplate.getForObject(host+EMPLOYEE_PATH_VI_END_POINT+"allEmpInfo", ArrayList.class);
    }

    public Employee getEmployeeInfoById(Integer empId){
        return restTemplate.getForObject(host+EMPLOYEE_PATH_VI_END_POINT+empId, Employee.class);
    }

    public URI saveEmployeeInfo(Employee emp){
        return restTemplate.postForLocation(host+EMPLOYEE_PATH_VI_END_POINT+"create", emp);
    }

    public void updateEmployeeById(Integer empId, BigDecimal salary){
        restTemplate.put(host+EMPLOYEE_PATH_VI_END_POINT+empId+"/"+salary, Employee.builder().build());
    }

    public void updateEmployee(Integer empId, Employee emp){
        restTemplate.put(host+EMPLOYEE_PATH_VI_END_POINT+empId, emp);
    }

    public void deleteEmployeeById(int empId){
        restTemplate.delete(host+EMPLOYEE_PATH_VI_END_POINT+empId);
    }

    public ResponseEntity deleteEmployee(Employee emp) throws Exception {
        HttpEntity<Employee> entity = new HttpEntity<Employee>(emp);
        ResponseEntity<String> resp = restTemplate.exchange(host+EMPLOYEE_PATH_VI_END_POINT+"delete", HttpMethod.DELETE, entity, String.class);
        return resp;
    }

    public void setHost(String host){
        this.host = host;
    }
}
