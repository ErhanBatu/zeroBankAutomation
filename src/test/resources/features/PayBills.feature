Feature: Pay Bills

  Background:
    Given the user is logged in

  Scenario: Pay Bills submit - positive
    When the user clicks on Pay Bills then title should contain "Zero – Pay Bills"
    And the user chooses "Apple" for Payee and "Loan" for Account
    Then the user enters the following data
      | 100                |
      | 01-03-2020         |
      | Loan from the bank |
    Then "The payment was successfully submitted" should be displayed

  Scenario Outline: Pay Bills submit - negative
    When the user clicks on Pay Bills then title should contain "Zero – Pay Bills"
    And the user chooses "Apple" for Payee and "Loan" for Account
    Then the user enters "<amount>" and "<date>"

    Examples:
      | amount | date       |
      |        |            |
      | twenty | JUN        |
      | $$$$   | 01-04-2020 |


