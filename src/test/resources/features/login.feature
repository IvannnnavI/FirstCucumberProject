Feature: Login

  @validData
  Scenario: Login with valid data
    Given User launches Chrome browser
    When User opens ilcarro Home Page
    And User clicks on Log in Link
    And User enters valid data
    And User clicks on Yala button
    Then User verifyes Success Message is displayed
    And User quites browser

  @invalidPassword
  Scenario Outline: Login with valid email and invalid password
    Given User launches Chrome browser
    When User opens ilcarro Home Page
    And User clicks on Log in Link
    And User enters valid email and invalid password
      | email   | password   |
      | <email> | <password> |
    And User clicks on Yala button
    Then User verifyes Error Message is displayed
    And User quites browser
    Examples:
      | email | password |
    |  test@mail.com     |     ee33aaaA     |
    |   test@mail.com    |      ee33!!aa    |
    |   test@mail.com    |       eee!!aaAA   |
    |    test@mail.com   |       EEE33!!AA   |