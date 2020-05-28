package com.karumien.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SampleProjectApplication {

    @Value("${ENVIRONMENT:dev}")
    private String env;
    
    @Value("${SECRET:secret}")
    private String secret;

    public static void main(String[] args) {
		SpringApplication.run(SampleProjectApplication.class, args);
	}

	@RequestMapping("/")
    public String home() {
        return "Hello on my <b>" + env + "</b> with secret <b>" + secret + "</b>!";
    }
}
