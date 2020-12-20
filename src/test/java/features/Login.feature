Feature: login

  Scenario:Correct login with valid credentials (username and password)
    Given Navigate to "https://www.trendyol.com"
    And Click the login menu
    And Enter username and password
    And Click the login form submit button
    Then Verify that the user is logged