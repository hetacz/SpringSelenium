package com.hetacz.springtests.config;

import com.github.javafaker.Faker;
import com.hetacz.springtests.annotations.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.time.Duration;

@LazyConfiguration
public class UtilsConfig {

    @Value("${timeout:30}")
    private int timeout;

    @Bean
    public WebDriverWait wait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}
