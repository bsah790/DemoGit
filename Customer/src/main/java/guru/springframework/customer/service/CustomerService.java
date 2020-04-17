package guru.springframework.customer.service;

import guru.springframework.customer.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    public CustomerDTO getCustomerById(UUID custId);
}
