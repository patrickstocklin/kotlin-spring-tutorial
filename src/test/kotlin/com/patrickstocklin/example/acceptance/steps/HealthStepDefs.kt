package com.patrickstocklin.example.acceptance.steps

import com.github.tomakehurst.wiremock.WireMockServer
import io.cucumber.java8.En
import junit.framework.Assert.assertEquals
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.ResponseEntity

import org.springframework.web.client.RestTemplate

class HealthStepDefs(@Autowired val wiremock: WireMockServer): En {

    @LocalServerPort
    lateinit var port: Integer

    lateinit var res: ResponseEntity<String>

    init {
        Given("my service is deployed") {
            println("Given")
            println(port)
            wiremock.stop()
        }

        When("i call my service") {
            println("W")
            res = RestTemplate().getForEntity("http://localhost:$port/health", String::class.java)
        }

        Then("i get a 200") {
            println("TTTT")
            assertEquals(200, res.statusCode.value())
        }
    }

}