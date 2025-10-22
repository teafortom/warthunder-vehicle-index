package com.tea4e.vehicleindexbackend.config;


import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "/application.properties")
public class DBProperties {
    String driver;
    String username;
    String password;
    String url;
}
