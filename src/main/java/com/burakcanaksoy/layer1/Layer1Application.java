package com.burakcanaksoy.layer1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Layer1Application {

    public static void main(String[] args) {
        SpringApplication.run(Layer1Application.class, args);
    }

}
