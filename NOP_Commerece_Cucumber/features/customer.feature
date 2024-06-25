
Feature: Customer

   Background: Below are the common steps for every scenario
    Given User launch the browser
    When User opens the URL "https://admin-demo.nopcommerce.com"
    And User enter email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User Can view dashboard


@Regression
  Scenario: Add a new customer
    When User click on customers menu
    And Click on customers menu item
    And Click on add new customer
    Then User can view add new customer page
    When User enter customer info
    And Click on save button
    Then User can view confirnation message "The new customer has been added successfully."
    And Close browser

@Smoke
 Scenario: Search customer By emaileId
    When User click on customers menu
    And Click on customers menu item
    And Enter customer email
    When Click on search button
    Then User should found email in the search table
    And Close browser
    
@Smoke
 Scenario: Search customer By emaileId
    When User click on customers menu
    And Click on customers menu item
    And Enter customer firstname
     And Enter customer lastname
    When Click on search button
    Then User should found name in the search table
    And Close browser
    