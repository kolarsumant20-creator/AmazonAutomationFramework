Feature: Amazon Product Search and Cart

  Scenario: Search for a product on Amazon
    Given user is on Amazon home page
    When user searches for "iPhone"
    Then search results should be displayed

  Scenario: Add product to cart from search results
    Given user is on Amazon home page
    When user searches for "iPhone"
    And user selects first product from results
    And user adds the product to cart
    Then cart count should be updated
