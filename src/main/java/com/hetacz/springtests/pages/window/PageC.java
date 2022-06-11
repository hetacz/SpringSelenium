package com.hetacz.springtests.pages.window;

import com.hetacz.springtests.base.BasePage;
import com.hetacz.springtests.framework.annotations.Page;
import com.hetacz.springtests.framework.annotations.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Window("Page C")
public class PageC extends BasePage {

    @FindBy(id = "area")
    private WebElement textarea;

    public void addToArea(String msg) {
        textarea.sendKeys(msg);
    }

    @Override
    public boolean isAt() {
        return wait.until((dr) -> textarea.isDisplayed());
    }
}
