package com.amazon.automation.stepdefinitions;

import org.testng.Assert;

import com.amazon.automation.factory.DriverFactory;
import com.amazon.automation.pages.AmazonCartPage;
import com.amazon.automation.pages.AmazonHomePage;
import com.amazon.automation.pages.AmazonProductPage;
import com.amazon.automation.pages.AmazonSearchResultsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

    private AmazonHomePage homePage;
    private AmazonSearchResultsPage resultsPage;
    private AmazonProductPage productPage;
    private int initialCartCount;
    private AmazonCartPage cartPage;


    //Result displayed after searching the product
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
    
    //Check the cart count after adding the product to the cart
    @When("user selects first product from results")
    public void user_selects_first_product_from_results() {
        resultsPage = new AmazonSearchResultsPage(DriverFactory.getDriver());
        resultsPage.clickFirstProductAndSwitchToTab();
    }

    @When("user adds the product to cart")
    public void user_adds_the_product_to_cart() {
        productPage = new AmazonProductPage(DriverFactory.getDriver());
        initialCartCount = productPage.getCartCountSafe();
        productPage.addToCart();
    }


    @Then("cart count should be updated")
    public void cart_count_should_be_updated() {

        productPage.goToCart();
        cartPage = new AmazonCartPage(DriverFactory.getDriver());

        Assert.assertTrue(cartPage.hasItemInCart(), "No item found in cart");
        Assert.assertTrue(cartPage.getQuantity() >= 1, "Item quantity is not valid");
    }


}
