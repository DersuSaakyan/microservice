package org.emred.customer.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class FraudClient {

    private final RestTemplate restTemplate;

    public Boolean isFraudster(Long customerId) {
        return restTemplate.getForObject("http://localhost:8082/api/v1/fraud-check/" + customerId, Boolean.class);
    }
}
