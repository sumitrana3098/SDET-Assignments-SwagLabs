@Assignment2ByExcel
Feature: 1. Write the script to create multiple order using parameters(Feature file using Examples or TestNG)
  2. Select the Multiple orders
  3. Click Shopping cart icon
  4. Enter the different checkout details (FirstName, LastName, PostalCode) using JSON and Excel and Fillo
  5. Checkout an Item and finish the order
  6. Verify the success message
  7. Click the menu icon and proceed Logout


  Background: Same Steps---
    Given launch chrome browser
    When open SwagLab Login Page
    Then user is on swaglab login page
    And user give UserName and Password
    And user is able to login

  @smoke
  Scenario Outline: Successfully done multiple orders by Json
    Given user is on SwagLab Home Page
    When user added multiple products to cart
    Then user able to go to shopping cart page
    And user able to checkout
    And enter the checkout details using excel sheetname "<SheetName>" and rownumber <RowNumber>
    And finish the order and get order successful message
    And Close the browser

    Examples:
      | SheetName | RowNumber |
      | Sheet1    | 0         |


