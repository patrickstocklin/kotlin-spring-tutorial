package com.patrickstocklin.example

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import io.cucumber.spring.CucumberContextConfiguration
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/resources"],
    plugin = ["pretty"],
    glue = []
)
@CucumberContextConfiguration
@ContextConfiguration(classes = [Application::class])
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CucumberConfig