package com.patrickstocklin.example.config

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import com.patrickstocklin.example.client.UserLookupClient
import feign.Feign
import feign.Logger
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder
import feign.okhttp.OkHttpClient
import feign.slf4j.Slf4jLogger
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ClientConfig {

    @Value("\${service.lookup.url}")
    lateinit var url: String

    @Value("\${wiremock.enabled}")
    lateinit var wiremockEnabled: String

    @Bean
    @ConditionalOnProperty(value=["wiremock.enabled"], havingValue = "true")
    fun wiremock() : WireMockServer {
        val wiremock = WireMockServer(WireMockConfiguration().dynamicPort())
        wiremock.start()
        return wiremock
    }

    @Bean
    fun userLookupClient() : UserLookupClient {
        return Feign.builder()
            .client(OkHttpClient())
            .encoder(GsonEncoder())
            .decoder(GsonDecoder())
            .logger(Slf4jLogger(UserLookupClient::class.java))
            .logLevel(Logger.Level.FULL)
            .target(UserLookupClient::class.java,
                if (wiremockEnabled.toBoolean()) wiremock().baseUrl() else url)
    }

}