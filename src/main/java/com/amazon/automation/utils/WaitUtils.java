package com.amazon.automation.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static void waitForVisibility(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(
                        Integer.parseInt(ConfigReader.get("explicitWait"))
                )
        );
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
