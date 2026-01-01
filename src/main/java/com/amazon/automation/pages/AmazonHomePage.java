package com.amazon.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage {

    private WebDriver driver;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchText(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void searchProduct(String productName) {
        enterSearchText(productName);
        clickSearchButton();
    }
}
