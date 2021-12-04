Feature: GoRest Comments api testcases including POST, PUT, GET and DELETE methods

  Background: GoRest Comments api authentication is valid

  Scenario Outline: Test the process flow of Comments API
    Given  Comments api is working and returning 200 status code
    When   User wants to add new Comments with <post_id>,<name>,<email> and <body>
    And    System can verify the new comments is add successfully
    Then   System should cleanUp new comments data
    And    System should verify that test data comments is removed successfully
    Examples:
      |post_id | name             |email                                  |   body                      |
      |12     | "Test Comments VM" |  "TestComments@wisoky-morissette.io"  |"Test comments for vlidation"|


  Scenario Outline: process flow to update comments information
    Given  Comments api is working and returning 200 status code
    When   User wants to add new Comments with <post_id>,<name>,<email> and <body>
    Then   User wants to update the <UpdatedEmail> in the comments details
    And    System can verify the new comments is add successfully
    Then   System should cleanUp new comments data
    And    System should verify that test data comments is removed successfully

    Examples:
      |post_id  | name               |email                                  |   body                      |UpdatedEmail                             |
      |12       | "Test Comments VM" |  "TestComments@wisoky-morissette.io"  |"Test comments for vlidation"|"TestCommentsUpdated@wisoky-morissette.io"|