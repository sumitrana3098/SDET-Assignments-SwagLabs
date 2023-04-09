@Assignment3

Feature: 1. Convert all the click and enter action
  2. Verify the negative cases of clicking login button without entering the ID / PWD / ID and Password.
  3. Script for the Filter and Sort order(Name(A to Z, Z to A) and Price(Low - High – Low)) functionality and verify the expected behavior.

  Background: Same Steps---

    Given open the browser
    When navigate to saucedemo login page

  @Login
  Scenario: Login functionality exists

    Given swaglabs logo should Exits
    When login button should Exits

  @Smoke
  Scenario Outline: Unsuccessful login

    Given enter Invalid <userName> and <passWord>
    When  click on Log in button
    Then An error message should be displayed

    Examples:
      | userName      | passWord     |
      | standard_user |              |
      |               | secret_sauce |
      |               |              |
      | sumit_rana    | rana_pandey  |

  @Sanity
  Scenario Outline: Successful login

    Given enter valid <UserName> and <PassWord>
    When click on Log in button
    Then should be login

    Examples:
      | UserName                | PassWord     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @Regression
  Scenario: Filter and Sort order

    Given  Enter username as standard_user and password as secret_sauce
    When  Click on log in button
    Then  Able to see product page
    And click on filter dropdown on right side
    And select Name(A to Z)
    And able to see the product alphabetically order(A toZ)
    And select Name(Z to A)
    And able to see the product alphabetically order(Z to A)
    And select Price(low to high)
    And able to see the product according to increasing price order
    And select Price(high to low)
    And able to see the product according to decreasing price order
    And Click on the menu strip on left side
    And Click on logout button
    And Able to see the login page again

