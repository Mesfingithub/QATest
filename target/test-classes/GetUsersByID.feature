Feature: Test Api-GetUsersByID
  Scenario: User is able to validate the GetUsersByID api response
    Given User sets the base api request url globally
    When  User sends the api request to get users by their userID number
    Then  User validates the response and the status code