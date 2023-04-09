@Assignment1

Feature: 1. Navigate to the Sample demo application link (https://www.saucedemo.com/)
  2. Login page with given user names/password
  3. Select an item for order
  4. Click Shopping cart icon
  5. Checkout an Item and finish the order
  6. Verify the success message
  7. Click the menu icon and proceed Logout

  Background: Same Steps---

    Given Open the browser
    When Navigate to saucedemo login page

  @Login
  Scenario: Login functionality exists

    Given Swaglabs logo should Exist
    When Login button should Exist

  @Sanity
  Scenario Outline: Successful login

    Given I enter valid <Username> and <Password>
    When I click on log in button
    Then I should be login

    Examples:
      | Username                | Password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @Regression
  Scenario: Add to cart and Logout

    Given  enter username as standard_user and password as secret_sauce
    When  click on log in button
    Then  able to see product page
    And  add an item to cart
    And able to see item in the cart
    And  I click Shopping Cart icon
    And  I Checkout an item and finish the order
    And  click on logout button
    And close browser

