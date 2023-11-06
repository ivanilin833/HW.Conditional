package com.example.conditionalapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConditionalAppApplicationTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Container
    private final GenericContainer<?> devapp = new GenericContainer<>("devapp:latest")
            .withExposedPorts(8080);
    @Container
    private final GenericContainer<?> prodapp = new GenericContainer<>("prodapp:latest")
            .withExposedPorts(8081);

    @Test
    void contextLoads() {
        ResponseEntity<String> forEntityDevapp = restTemplate.getForEntity("http://localhost:" + devapp.getMappedPort(8080) + "/profile", String.class);
        ResponseEntity<String> forEntityProdapp = restTemplate.getForEntity("http://localhost:" + prodapp.getMappedPort(8081) + "/profile", String.class);
        Assertions.assertEquals("Current profile is product",forEntityProdapp.getBody());
        Assertions.assertEquals("Current profile is dev",forEntityDevapp.getBody());
    }

}
