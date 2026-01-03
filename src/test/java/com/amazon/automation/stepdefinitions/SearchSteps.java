package com.amazon.automation.stepdefinitions;

import org.testng.Assert;

import com.amazon.automation.factory.DriverFactory;
import com.amazon.automation.pages.AmazonHomePage;
import com.amazon.automation.pages.AmazonSearchResultsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

    private AmazonHomePage homePage;
    private AmazonSearchResultsPage resultsPage;

    @Given("user is on Amazon home page")
    public void user_is_on_amazon_home_page() {
        homePage = new AmazonHomePage(DriverFactory.getDriver());
    }

    @When("user searches for {string}")
    public void user_searches_for_product(String product) {
        homePage.searchProduct(product);
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        resultsPage = new AmazonSearchResultsPage(DriverFactory.getDriver());
        Assert.assertTrue(
                resultsPage.hasResults(),
                "Search results are not displayed"
        );
    }
}
