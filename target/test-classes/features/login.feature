
Feature: Authorized login

  Background:
    Given the user on the signin page

  Scenario: Login with valid credential
    When user logs in with valid credentials
    Then The title contains "Account Summary"

  Scenario Outline: Login with invalid credentials <username>
    When the user is logged in as "<username>" "<password>"
    And the user clicks signin
    Then error message is displayed as "Login and/or password are wrong."

    Examples:
    |username|password|
    |Erhan   |Batu    |
    |        |        |
