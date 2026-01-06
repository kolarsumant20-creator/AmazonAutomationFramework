package com.amazon.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.automation.utils.WaitUtils;

public class AmazonProductPage {

    private WebDriver driver;

    @FindBy(name = "submit.addToCart")
    private WebElement addToCartButton;

    @FindBy(id = "nav-cart-count")
    private WebElement cartCount;
    
    @FindBy(id = "nav-cart")
    private WebElement cartIcon;


    public AmazonProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        WaitUtils.waitForVisibility(driver, addToCartButton);
        addToCartButton.click();
    }

    public int getCartCount() {
        return Integer.parseInt(cartCount.getText());
    }
    
    public int getCartCountSafe() {
        String count = cartCount.getText().trim();
        if (count.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(count);
    }
    
    public void goToCart() {
        cartIcon.click();
    }



}
