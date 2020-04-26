package guru.springframework.employee.web.config;

import guru.springframework.employee.web.model.Employee;
import guru.springframework.employee.web.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDataLoader implements CommandLineRunner {
    @Autowired
    private EmployeeRepository repo;
    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
        List<Employee> list = new ArrayList<>();
        list.add(Employee.builder().empName("Ramayan").address("Kolkata").salary(new BigDecimal(5000)).build());
        list.add(Employee.builder().empName("Naresh").address("Bihar").salary(new BigDecimal(7500)).build());
        list.add(Employee.builder().empName("Mukesh").address("Nalanda").salary(new BigDecimal(7800)).build());
        list.add(Employee.builder().empName("Abhishek").address("Naktala").salary(new BigDecimal(15000)).build());
        list.add(Employee.builder().empName("Pinaki").address("BaruiPur").salary(new BigDecimal(2800)).build());
      if(repo.count() == 0) {
          repo.saveAll(list);
      }
    }
}
