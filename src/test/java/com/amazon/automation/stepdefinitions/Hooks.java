package com.amazon.automation.stepdefinitions;

import com.amazon.automation.factory.DriverFactory;
import com.amazon.automation.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver()
                .get(ConfigReader.get("url"));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
