package com.hetacz.springtests.config;

import com.hetacz.springtests.annotations.LazyConfiguration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {

    @Bean
    @Scope("browserScope")
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().cachePath("drivers").setup();
        return new ChromeDriver();
    }

    @Bean
    @Scope("browserScope")
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().cachePath("drivers").setup();
        return new FirefoxDriver();
    }
}
