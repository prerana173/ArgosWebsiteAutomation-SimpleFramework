Feature: Adding products and modifying the product quantity in Argos Trolley page

  As a shopper on the Argos website
  I want to be able to add products in my basket, change quantity
  and expect the subtotal to adjust accordingly.

  //Note - This feature file contains same scenarios written in productPriceValidationInCart.feature file,
  //but these are written in a slightly different, simpler way.

  Scenario: Validate search result page content matches the search criteria entered
    Given I am on the Argos website
    When I search for "product_name"
    Then I should see search results containing "product_name"

  Scenario: Validate the added product in the basket
    Given I am on the search results page containing "product_name"
    When I add the first product to the basket
    Then I should see "product_name" in the basket

  Scenario: Increase quantity of product in the basket and validate subtotal
    Given I am on the Argos Trolley page with "product_name" in the basket
    When I increase the quantity by 2
    Then the subtotal should be updated accordingly