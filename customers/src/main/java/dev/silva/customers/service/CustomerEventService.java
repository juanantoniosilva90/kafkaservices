package dev.silva.customers.service;

import dev.silva.customers.entity.Customer;
import dev.silva.customers.events.CustomerCreatedEvent;
import dev.silva.customers.events.Event;
import dev.silva.customers.events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class CustomerEventService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;


    @Value("${topic.customer.name:customers}")
    private String topicCustomer;

    public void publish(Customer customer){

        CustomerCreatedEvent created = new CustomerCreatedEvent();
        created.setData(customer);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicCustomer, created);



    }



}
