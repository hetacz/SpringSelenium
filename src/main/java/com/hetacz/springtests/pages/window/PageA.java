package com.hetacz.springtests.pages.window;

import com.hetacz.springtests.base.BasePage;
import com.hetacz.springtests.framework.annotations.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page A")
public class PageA extends BasePage {

    @FindBy(id = "area")
    private WebElement textarea;

    public void addToArea(String msg) {
        textarea.sendKeys(msg);
    }

    @Override
    public boolean isAt() {
        return wait.until((dr) -> textarea.isDisplayed());
    }

    // PageB and PageC are exact copies (and pages they represent are very similar to each other too),
    // but I keep them separate only for demo reasons.
}
