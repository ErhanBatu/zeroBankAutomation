
Feature: Account Summary page

  Background:
    Given the user is logged in
    And The title contains "Account Summary"

  Scenario: Account Types
    Then Account summary page should have to following options
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |
    And Credit Accounts page should have to following options
      | Account     |
      | Credit Card |
      | Balance    |


