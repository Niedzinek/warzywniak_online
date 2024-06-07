package com.example.demo.KeycloakUtils;

import com.example.demo.Models.Customer;
import com.example.demo.Services.CustomerService;
import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventType;
import org.keycloak.events.admin.AdminEvent;
import org.springframework.context.ApplicationContext;

public class SampleEventListenerProvider implements EventListenerProvider {

    private ApplicationContext applicationContext;
    @Override
    public void onEvent(Event event) {
        if(event.getType().equals(EventType.REGISTER)){
            String userId = event.getUserId();
            String email = event.getDetails().get("email");
            String username = event.getDetails().get("username");
            String firstName = event.getDetails().get("firstname");
            String lastName = event.getDetails().get("lastname");

            CustomerService customerService = applicationContext.getBean(CustomerService.class);
            Customer customer = new Customer();
            customer.setUserId(userId);
            customer.setEmail(email);
            customer.setLogin(username);
            customer.setFirstName(firstName);
            customer.setLastName(lastName);

            customerService.createCustomer(customer);
        }

    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {

    }

    @Override
    public void close() {

    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

}
