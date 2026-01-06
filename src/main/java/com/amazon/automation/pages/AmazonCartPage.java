package com.amazon.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonCartPage {

    private WebDriver driver;

    @FindBy(css = "div.sc-list-item")
    private WebElement cartItem;

    @FindBy(css = "span[data-a-selector='value']")
    private WebElement quantityValue;

    public AmazonCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean hasItemInCart() {
        return cartItem.isDisplayed();
    }

    public int getQuantity() {
        return Integer.parseInt(quantityValue.getText().trim());
    }
}
