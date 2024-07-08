Feature: Let the car work

  @letTheCarWorkSuccessAdd
  Scenario: Fill out the car work form with valid data
    Given User launches Chrome browser
    When User opens ilcarro Home Page
    And User logs in with valid credentials
    And User navigates to Let the car work page
    And User selects pick up place "Tel Aviv, Israel"
    And User fills in car work form with valid data
    And User clicks on Submit button
    Then User verifies Success Message is displayed
    And User quits browser
