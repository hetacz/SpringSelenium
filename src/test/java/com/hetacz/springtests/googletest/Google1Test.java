package com.hetacz.springtests.googletest;

import com.google.common.util.concurrent.Uninterruptibles;
import com.hetacz.springtests.BaseTest;
import com.hetacz.springtests.framework.annotations.LazyAutowired;
import com.hetacz.springtests.pages.google.GooglePage;
import com.hetacz.springtests.framework.service.Screenshot;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Google1Test extends BaseTest {

    @LazyAutowired
    private GooglePage googlePage;
    @LazyAutowired
    private Screenshot screenShot;

    @Test
    public void googleTest() throws IOException {
        googlePage.goTo();
        Assertions.assertThat(googlePage.isAt()).isEqualTo(true);
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
        googlePage.getSearchComponent().closeCookies();
        googlePage.getSearchComponent().search("Spring boot");
        Assertions.assertThat(googlePage.getSearchResult().isAt()).isEqualTo(true);
        Assertions.assertThat(googlePage.getSearchResult().getCount()).isGreaterThan(2);
        screenShot.takeScreenShot();
    }
}
