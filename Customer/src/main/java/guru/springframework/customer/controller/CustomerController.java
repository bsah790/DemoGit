package guru.springframework.customer.controller;

import guru.springframework.customer.model.CustomerDTO;
import guru.springframework.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @GetMapping("/{custId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("custId") UUID custId){
        return new ResponseEntity(service.getCustomerById(custId),HttpStatus.OK);
    }
}
