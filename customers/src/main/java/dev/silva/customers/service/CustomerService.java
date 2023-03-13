package dev.silva.customers.service;

import dev.silva.customers.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerEventService customerEventService;
    private CustomerEventService customerEventsService;

    public CustomerService(CustomerEventService customerEventService){
        super();

        this.customerEventService = customerEventService;
    }

    public Customer save(Customer customer) {
        System.out.println("Received " + customer);
        this.customerEventsService.publish(customer);
        return customer;

    }




}
