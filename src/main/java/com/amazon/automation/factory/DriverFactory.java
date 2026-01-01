package com.amazon.automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.amazon.automation.utils.ConfigReader;

public class DriverFactory {
	
	//ThreadLocal for parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver() {
        String browser = ConfigReader.get("browser");
        boolean headless = Boolean.parseBoolean(ConfigReader.get("headless"));

        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (headless) {
                options.addArguments("--headless=new");
            }
            driver.set(new ChromeDriver(options));
        }

        driver.get().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
}
