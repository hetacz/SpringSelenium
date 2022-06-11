package com.hetacz.springtests.pages.window;

import com.hetacz.springtests.base.BasePage;
import com.hetacz.springtests.framework.annotations.Page;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;

import java.time.Duration;
import java.util.List;

@Page
public class MainPage extends BasePage {

    @FindBy(tagName = "a")
    private List<WebElement> links;

    public void goTo() {
        driver.get("https://vins-udemy.s3.amazonaws.com/ds/window/main.html");
    }

    @SneakyThrows
    public void launchAllWindows() {
        links.forEach(WebElement::click);
        wait.until(ExpectedConditions.numberOfWindowsToBe(links.size() + 1));
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofSeconds(3));
    }

    @Override
    public boolean isAt() {
        return wait.until(dr -> !links.isEmpty());
    }
}
