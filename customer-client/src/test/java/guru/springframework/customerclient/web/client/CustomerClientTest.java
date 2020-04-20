package guru.springframework.customerclient.web.client;

import guru.springframework.customerclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient client;

    @Test
    void getCustomerByIdTest() {
        CustomerDto dto = client.getCustomerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveCustomerTest(){
        CustomerDto dto = CustomerDto.builder().customerName("TestName").build();
        URI uri = client.saveCustomer(dto);
        assertNotNull(uri);
    }

    @Test
    void updateCustomerTest(){
        CustomerDto dto = CustomerDto.builder().customerName("TestName").build();
        client.updateCustomer(UUID.randomUUID(),dto);
    }

    @Test
    void deleteCustomerTest(){
        client.deleteCustomer(UUID.randomUUID());
    }
}