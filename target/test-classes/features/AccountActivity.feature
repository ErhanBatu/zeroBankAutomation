@wip
Feature: Account Activity

  Background:
    Given the user is logged in

  Scenario: Dropdown elements in the Account Activity
    When the user clicks on Savings link on the Account Summary page
    Then the default option should be "Savings"
    And Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    And Transactions table should have the following options
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |