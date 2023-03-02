package org.emred.customer.client;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class NotificationClient {

    private final RestTemplate restTemplate;

    public void send(String message) {
        restTemplate.postForEntity("http://notification:8083/api/v1/notifications/send", null, Void.class);
    }
}
