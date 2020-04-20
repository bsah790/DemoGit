package guru.springframework.customerclient.web.client;

import guru.springframework.customerclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "cust.api", ignoreUnknownFields = false)
public class CustomerClient {

    public final String CUSTOMER_PATH_V1="/api/v1/customer/";
    private String host;
    private final RestTemplate restTemplate;

    CustomerClient(RestTemplateBuilder builder){
        restTemplate = builder.build();
    }

    public CustomerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(host+CUSTOMER_PATH_V1+uuid.toString(), CustomerDto.class);
    }

    public URI saveCustomer(CustomerDto dto){
        return restTemplate.postForLocation(host+CUSTOMER_PATH_V1+"create", dto);
    }

    public void updateCustomer(UUID uuid, CustomerDto dto){
        restTemplate.put(host+CUSTOMER_PATH_V1+uuid.toString(), dto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(host+CUSTOMER_PATH_V1+uuid.toString());
    }
    public void setHost(String host){
        this.host = host;
    }
}
