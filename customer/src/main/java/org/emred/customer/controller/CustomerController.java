package org.emred.customer.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.emred.customer.dto.CustomerRegistrationRequest;
import org.emred.customer.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public void customerRegistration(@RequestBody CustomerRegistrationRequest registrationRequest) {
        customerService.customerRegistration(registrationRequest);
    }
}
