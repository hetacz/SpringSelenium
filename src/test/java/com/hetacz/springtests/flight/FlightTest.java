package com.hetacz.springtests.flight;

import com.hetacz.springtests.BaseTest;
import com.hetacz.springtests.pages.flights.FlightPO;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class FlightTest extends BaseTest {

    @Autowired
    private FlightPO flightPO;

    @Autowired
    private FlightAppDetails appDetails;

    @Test
    public void flightTest() {
        flightPO.goTo(appDetails.getUrl());
        Assertions.assertThat(flightPO.isAt()).isTrue();
        Assertions.assertThat(flightPO.getLabels()).isEqualTo(appDetails.getLabels());
        flightPO.tearDown();
    }
}
