
Feature: Login
  I want to use this template for my feature file

 
  Scenario: Succesful Login with valid Credentials
    Given  User Launch Chrome browser
    When User Opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User  enters email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page title shpuld be "Dashboard / nopCommerce administration"
    When user clicks Logout link
    Then page title should be "Your store. Login"
    And close Browser
    
     
  Scenario Outline: Login with Data Driven
    Given  User Launch Chrome browser
    When User Opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User  enters email as "<email>" and password as "<password>"
    And Click on Login
    Then Page title shpuld be "Dashboard / nopCommerce administration"
    When user clicks Logout link
    Then page title should be "Your store. Login"
    And close Browser
    
    Examples:
    | email | password |
    | admin@yourstore.com | admin |

