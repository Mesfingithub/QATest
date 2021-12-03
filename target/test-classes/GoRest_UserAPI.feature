Feature: GoRest User api testcases including POST, PUT, GET and DELETE methods

  Background: GoRest User api authentication is valid

        Scenario Outline: Test the process flow of User API
          Given  User api is working and returning 200 status code
          When   User wants to add new user with  <name>,<email>,<gender> and <status>
          And    System can verify the new user is add successfully
          Then   System should cleanUp new user data
          And    System should verify that test data user is removed successfully
          Examples:
          |name           | email                  |   gender   | status  |
          |"TestUserM55"  | "testM55User@demo.com" |  "male"    | "active"|
          |"TestUserM56"  | "testM56User@demo.com" |  "male"    | "active"|
          |"TestUserM57"  | "testM57User@demo.com" |  "male"    | "active"|

Scenario Outline: process flow to update user information
  Given  User api is working and returning 200 status code
  When   User wants to add new user with  <name>,<email>,<gender> and <status>
  Then   User wants to update the <updatedEmail> in the user details
  And    System can verify the new user is add successfully
  Then   System should cleanUp new user data
  And    System should verify that test data user is removed successfully

  Examples:
    |name           | email                  |   gender   | status   | updatedEmail             |
    |"TestUserM51"  | "testM55User@demo.com" |  "male"    | "active" | "updateM58User@demo.com" |

