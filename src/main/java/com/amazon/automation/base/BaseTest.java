package com.amazon.automation.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.amazon.automation.factory.DriverFactory;
import com.amazon.automation.utils.ConfigReader;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.initDriver();
        DriverFactory.getDriver()
                .get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
