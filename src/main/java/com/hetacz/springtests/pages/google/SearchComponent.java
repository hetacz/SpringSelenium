package com.hetacz.springtests.pages.google;

import com.hetacz.springtests.framework.annotations.PageComponent;
import com.hetacz.springtests.base.BasePage;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageComponent
public class SearchComponent extends BasePage {

    @FindBy(xpath = "//button[2]")
    private List<WebElement> consentBtn;
    @FindBy(name = "q")
    private WebElement searchBox;
    @FindBy(name = "btnK")
    private List<WebElement> searchBtns;

    @Override
    public boolean isAt() {
        return wait.until(dr -> searchBox.isDisplayed());
    }

    public void closeCookies() {
        if (!consentBtn.isEmpty()) {
            try {
                consentBtn.get(0).click();
            } catch (ElementNotInteractableException e) {
                consentBtn.get(0).click();
            }
        }
    }

    public void search(String keyword) {
        searchBox.sendKeys(keyword);
        searchBtns
                .stream()
                .filter(WebElement::isDisplayed)
                .filter(WebElement::isEnabled)
                .findFirst()
                .ifPresent(WebElement::click);
    }
}
