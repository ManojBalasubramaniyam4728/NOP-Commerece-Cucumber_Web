
Feature: Login
  
  @Regression
  Scenario: Successfull login with valid credentials
    Given User launch the browser
    When User opens the URL "https://admin-demo.nopcommerce.com"
    And User enter email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    Then Page title should be "Your store. Login"
    And Close browser


  @Smoke
  Scenario: Login Data Driven
    Given User launch the browser
    When User opens the URL "https://admin-demo.nopcommerce.com"
    And User enter email as "<email>" and password as "<password>"
    And Click on login
    Then Page title should be "Dashboard / nopCommerce administration"
    When User click on log out link
    Then Page title should be "Your store. Login"
    And close browser
    
  Examples:
     |email|password|
     |admin@yourstore.com|admin|
     |admin@yourstore.com|admin@123|
     
