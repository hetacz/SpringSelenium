package com.hetacz.springtests.flight;

import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "app.locale=en")
public class EnFlightTest extends FlightTest {

}
