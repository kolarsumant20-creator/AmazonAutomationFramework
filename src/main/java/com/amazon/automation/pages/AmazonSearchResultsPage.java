package com.amazon.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchResultsPage {

    private WebDriver driver;

    @FindBy(css = "div.s-main-slot div[data-component-type='s-search-result']")
    private List<WebElement> searchResults;

    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean hasResults() {
        return searchResults.size() > 0;
    }

    public int getResultsCount() {
        return searchResults.size();
    }
}
