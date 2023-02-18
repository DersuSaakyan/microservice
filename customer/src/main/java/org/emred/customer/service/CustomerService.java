package org.emred.customer.service;

import lombok.RequiredArgsConstructor;
import org.emred.customer.domain.Customer;
import org.emred.customer.dto.CustomerRegistrationRequest;
import org.emred.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public void customerRegistration(CustomerRegistrationRequest request) {
        final Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        customerRepository.save(customer);
    }
}
