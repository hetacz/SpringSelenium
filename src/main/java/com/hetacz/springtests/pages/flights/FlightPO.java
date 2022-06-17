package com.hetacz.springtests.pages.flights;

import com.hetacz.springtests.base.BasePage;
import com.hetacz.springtests.framework.annotations.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class FlightPO extends BasePage {

    @FindBy(css = "a[href^='/travel']")
    private List<WebElement> linkNavs;

    public List<String> getLabels() {
        return linkNavs
                .stream()
                .map(WebElement::getText)
                .map(String::strip)
                .toList();
    }

    public void goTo(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Override
    public boolean isAt() {
        return wait.until(dr -> !linkNavs.isEmpty());
    }
}
