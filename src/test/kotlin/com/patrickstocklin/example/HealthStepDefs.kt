package com.patrickstocklin.example

import io.cucumber.java8.En
import junit.framework.Assert
import junit.framework.Assert.assertEquals

import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.ResponseEntity

import org.springframework.web.client.RestTemplate

class HealthStepDefs: En {

    @LocalServerPort
    lateinit var port: Integer

    lateinit var res: ResponseEntity<String>

    init {
        Given("my service is deployed") {
            println("Given")
            println(port)
        }

        When("i call my service") {
            println("W")
            res = RestTemplate().getForEntity("http://localhost:" + port + "/health", String::class.java)
        }

        Then("i get a 200") {
            println("TTTT")
            assertEquals(200, res.statusCode.value())
        }
    }

}