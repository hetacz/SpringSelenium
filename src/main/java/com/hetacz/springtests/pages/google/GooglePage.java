package com.hetacz.springtests.pages.google;

import com.hetacz.springtests.framework.annotations.Page;
import com.hetacz.springtests.base.BasePage;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends BasePage {

    @Autowired
    @Getter
    private SearchComponent searchComponent;
    @Autowired
    @Getter
    private SearchResult searchResult;
    @Value("${application.url}")
    private String url;

    public void goTo() {
        driver.get(url);
    }

    @Override
    public boolean isAt() {
        return searchComponent.isAt();
    }
}
