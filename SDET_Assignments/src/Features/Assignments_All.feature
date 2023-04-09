@Assignments_All
Feature: End to End Scenario

  Background: Same Steps---

    Given Open the Browser
    When Navigate to Saucedemo login page

  @Login
  Scenario: Login functionality exists

    Given Swaglabs Logo should Exist
    When Login Button should Exist

  @Smoke
  Scenario Outline: Unsuccessful login

    Given Enter Invalid <userName> and <passWord>
    When  Click on Log in button
    Then An Error message should be displayed

    Examples:
      | userName      | passWord     |
      | standard_user |              |
      |               | secret_sauce |
      |               |              |
      | sumit_rana    | rana_pandey  |

  @Sanity
  Scenario Outline: Successful login

    Given Enter valid <Username> and <Password>
    When Click on Log in button
    Then Should be login
    Examples:
      | Username                | Password     |
      | standard_user           | secret_sauce |
      | problem_user            | secret_sauce |
      | performance_glitch_user | secret_sauce |

  @Multiple
  Scenario Outline: Successfully done multiple orders by Excel

    Given User give UserName and Password
    When User is able to login
    Then User is on SwagLab Home Page
    And User added multiple products to cart
    And User able to go to shopping cart page
    And User able to checkout
    And Enter the checkout details using excel sheetname "<SheetName>" and rownumber <RowNumber>
    And Finish the order and get order successful message
    And Close the Browser

    Examples:
      | SheetName | RowNumber |
      | Sheet1    | 0         |

  @Filter
  Scenario: Filter and Sort order

    Given Enter Username as standard_user and Password as secret_sauce
    When Click on Log in button
    Then Able to see Product page
    And Click on filter dropdown on right side
    And Select Name(A to Z)
    And Able to see the product alphabetically order(A toZ)
    And Select Name(Z to A)
    And Able to see the product alphabetically order(Z to A)
    And Select Price(low to high)
    And Able to see the product according to increasing price order
    And Select Price(high to low)
    And Able to see the product according to decreasing price order
    And Click on the Menu strip on left side
    And Click on Logout button
    And Able to see the Login page again

