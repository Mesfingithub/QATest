Feature: Test Api-GetSomeUsersByID
  Scenario: User is able to validate GetSomeUsersByID api response
    Given User sets the base api request url globally-GetSomeUserByID
    When  User sends the api request to get some users by their usersID number
    Then  User validates the response and the status code accordingly