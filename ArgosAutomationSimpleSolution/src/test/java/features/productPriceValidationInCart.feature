Feature: Validating the added products in the basket and verifying subtotal change

  As a shopper on the Argos website
  I want to be able to add products in my basket, change quantity
  and expect the subtotal to adjust accordingly.

  Background:
    Given I am on the Argos website

  Scenario Outline: Search for a product, add it to the basket, and validate
    When I search for "<product_name>"
    Then I should see search results containing "<product_name>"
    When I add the first product to the basket
    Then I should see "<product_name>" in the basket
    Examples:
      | product_name      |
      | Yoga Exercise Mat |

  Scenario Outline: Increase quantity of product in the basket and validate subtotal
    When I search for "<product_name>"
    And I add the first product to the basket
    And I increase the quantity by 2
    Then the subtotal should be updated accordingly
    Examples:
      | product_name      |
      | Yoga Exercise Mat |