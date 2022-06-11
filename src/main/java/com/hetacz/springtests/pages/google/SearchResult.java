package com.hetacz.springtests.pages.google;

import com.hetacz.springtests.framework.annotations.PageComponent;
import com.hetacz.springtests.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageComponent
public class SearchResult extends BasePage {

    @FindBy(css = "div.g.tF2Cxc")
    private List<WebElement> results;

    @Override
    public boolean isAt() {
        return wait.until(dr -> !results.isEmpty());
    }

    public int getCount() {
        return results.size();
    }
}
