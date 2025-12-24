@tag
Feature: Place an order in ecommerce websites

  Background:
  Given Launch the browser and application site
 
  @Regression
  Scenario Outline: Place an order with requested product name
    Given User login with <username> and <password>
    When Search of required <product>
    And Move to cart page by clicking on Cart link
    And Verify for the <product> added in cart
    And place and order by selecting the <countryname> in the billing page
    Then Verify the <product> order placed
    And verify the <successmessage> after placing the order

    Examples: 
      | username               | password | product     | countryname | successmessage         |
      | ajayselenium@gmail.com | Ajay@123 | ZARA COAT 3 | India       | Thankyou for the order.|