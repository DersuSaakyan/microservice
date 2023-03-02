package org.emred.customer.service;

import lombok.RequiredArgsConstructor;
import org.emred.customer.client.FraudClient;
import org.emred.customer.client.NotificationClient;
import org.emred.customer.domain.Customer;
import org.emred.customer.dto.CustomerRegistrationRequest;
import org.emred.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final FraudClient fraudClient;
    private final CustomerRepository customerRepository;
    private final NotificationClient notificationClient;

    public void customerRegistration(CustomerRegistrationRequest request) {
        final Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        customerRepository.saveAndFlush(customer);

        boolean fraudCheckResponse = fraudClient.isFraudster(customer.getId());
        notificationClient.send("Hi");

        if (fraudCheckResponse) {
            throw new IllegalStateException("fraudster");
        }
    }
}
