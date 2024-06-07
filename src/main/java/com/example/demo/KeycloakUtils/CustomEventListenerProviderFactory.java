package com.example.demo.KeycloakUtils;

import com.example.demo.AppConfig;
import org.keycloak.Config;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomEventListenerProviderFactory implements EventListenerProviderFactory {

    private ApplicationContext applicationContext;

    @Override
    public EventListenerProvider create(KeycloakSession session) {
        if (applicationContext == null) {
            applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig to Twoja klasa konfiguracji Spring
        }
        SampleEventListenerProvider provider = new SampleEventListenerProvider();
        provider.setApplicationContext(applicationContext);
        return provider;
    }

    @Override
    public void init(Config.Scope config) {
        // Initialization if needed
    }

    @Override
    public void postInit(KeycloakSessionFactory factory) {
        // Post initialization if needed
    }

    @Override
    public void close() {
        // Cleanup if needed
    }

    @Override
    public String getId() {
        return "custom-event-listener";
    }
}
