Feature: Amazon Product Search

  Scenario: Search for a product on Amazon
    Given user is on Amazon home page
    When user searches for "iPhone"
    Then search results should be displayed
