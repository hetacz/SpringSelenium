package com.hetacz.springtests.framework.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class WindowHandle {

    @Autowired
    private ApplicationContext ctx;

    public void switchByTitle(String title) {
        WebDriver driver = ctx.getBean(WebDriver.class);
        driver.getWindowHandles()
                .stream()
                .map(handle -> driver.switchTo().window(handle).getTitle())
                .filter(windowTitle -> Objects.equals(windowTitle, title))
                .findFirst()
                .orElseThrow(() -> {
                    throw new RuntimeException("No window with this title: %s".formatted(title));
                });
    }

    public void switchByIndex(int index) {
        WebDriver driver = ctx.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(String[]::new);
        driver.switchTo().window(handles[index]);
    }
}
