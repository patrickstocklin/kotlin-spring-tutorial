package com.patrickstocklin.example.acceptance

import com.patrickstocklin.example.Application
import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import io.cucumber.spring.CucumberContextConfiguration
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/resources/feature"],
    plugin = ["pretty"],
    glue = []
)
@CucumberContextConfiguration
@ContextConfiguration(classes = [Application::class])
@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = ["wiremock.enabled=true"])
class CucumberConfig