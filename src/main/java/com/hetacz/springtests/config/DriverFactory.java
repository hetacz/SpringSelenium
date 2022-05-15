package com.hetacz.springtests.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Lazy
//@Component
public class DriverFactory {

    @Value("browser")
    private String browser;

//    public WebDriver getDriver(String browser) {
//        return switch (browser) {
//            case "chrome" -> getChrome();
//            case "firefox" -> getFirefox();
//            default -> throw new RuntimeException();
//        };
//    }

    public WebDriver getDriver() {
        return switch (browser) {
            case "chrome" -> getChrome();
            case "firefox" -> getFirefox();
            default -> throw new RuntimeException();
        };
    }

    @Contract(" -> new")
    private @NotNull WebDriver getChrome() {
        WebDriverManager.chromedriver().cachePath("drivers").setup();
        return new ChromeDriver();
    }

    @Contract(" -> new")
    private @NotNull WebDriver getFirefox() {
        WebDriverManager.firefoxdriver().cachePath("drivers").setup();
        return new FirefoxDriver();
    }
}
