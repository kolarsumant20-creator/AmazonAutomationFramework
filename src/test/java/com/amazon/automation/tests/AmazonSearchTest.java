package com.amazon.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.automation.base.BaseTest;
import com.amazon.automation.factory.DriverFactory;
import com.amazon.automation.pages.AmazonHomePage;
import com.amazon.automation.pages.AmazonSearchResultsPage;

public class AmazonSearchTest extends BaseTest {

    @Test
    public void verifyProductSearch() {

        AmazonHomePage homePage =
                new AmazonHomePage(DriverFactory.getDriver());

        homePage.searchProduct("iPhone");

        AmazonSearchResultsPage resultsPage =
                new AmazonSearchResultsPage(DriverFactory.getDriver());

        Assert.assertTrue(
                resultsPage.hasResults(),
                "Search results are not displayed"
        );

        System.out.println(
                "Search successful. Results count: "
                        + resultsPage.getResultsCount()
        );
    }
}
