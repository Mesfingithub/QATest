Feature: Test Api-GetAllUsers
  Scenario: User is able to validate the api response
    Given User sets the base api request url
    When  User sends the api request to get all the data
    Then  User validates the response the status code