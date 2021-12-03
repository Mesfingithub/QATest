Feature: GET User API test cases

  Background: USER API is working as expected.
    Scenario: User api call with list of all users
      Given System calls user api with valid url
      When  User api return responses with status code 200
      Then  System should validate api response with list of users
