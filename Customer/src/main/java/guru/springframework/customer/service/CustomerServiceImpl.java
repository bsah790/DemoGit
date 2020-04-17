package guru.springframework.customer.service;

import guru.springframework.customer.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById(UUID custId) {
        return CustomerDTO.builder().id(UUID.randomUUID()).customerName("ShyamSundra").build();
    }
}
