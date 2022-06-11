package com.hetacz.springtests.googletest;

import com.google.common.util.concurrent.Uninterruptibles;
import com.hetacz.springtests.BaseTest;
import com.hetacz.springtests.pages.google.GooglePage;
import com.hetacz.springtests.framework.service.Screenshot;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GoogleTest extends BaseTest {

    @Autowired
    @Lazy
    private GooglePage googlePage;
    @Autowired
    @Lazy
    private Screenshot screenShot;

    @Test
    public void googleTest() throws IOException {
        googlePage.goTo();
        Assertions.assertThat(googlePage.isAt()).isEqualTo(true);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        googlePage.getSearchComponent().closeCookies();
        googlePage.getSearchComponent().search("Environment");
        Assertions.assertThat(googlePage.getSearchResult().isAt()).isEqualTo(true);
        Assertions.assertThat(googlePage.getSearchResult().getCount()).isGreaterThan(2);
        screenShot.takeScreenShot();
        googlePage.close();
    }
}
