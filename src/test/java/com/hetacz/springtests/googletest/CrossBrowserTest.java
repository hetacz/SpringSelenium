package com.hetacz.springtests.googletest;

import com.hetacz.springtests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

public class CrossBrowserTest extends BaseTest {

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void browserTest() {
        // comment out @ConditionalOnMissingBean in WebDriverConfig when using this method
        ctx.getBean("chromeDriver", WebDriver.class).get("https://www.google.com");
        ctx.getBean("firefoxDriver", WebDriver.class).get("https://www.yahoo.com");
    }
}
