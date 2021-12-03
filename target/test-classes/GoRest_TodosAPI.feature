Feature: GoRest Todos api testcases including POST, PUT, GET and DELETE methods

  Background: GoRest Todos api authentication is valid

  Scenario Outline: Test the process flow of Todos API
    Given  Todos api is working and returning 200 status code
    When   User wants to add new Todos with <user_id>,<title>,<due_on> and <status>
    And    System can verify the new todos is add successfully
    Then   System should cleanUp new todos data
    And    System should verify that test data todos is removed successfully
    Examples:
      |user_id | title                           |   due_on                           | status   |
      |8       | "Amplitudo absconditus 38....." |  "2021-12-06T00:00:00.000+05:30"   | "pending"|
      |12      | "Amplitudo absconditus 39....." |  "2021-12-06T00:00:00.000+05:30"   | "pending"|
      |13      | "Amplitudo absconditus 40....." |  "2021-12-06T00:00:00.000+05:30"   | "pending"|


  Scenario Outline: process flow to update todos information
    Given  Todos api is working and returning 200 status code
    When   User wants to add new Todos with <user_id>,<title>,<due_on> and <status>
    Then   User wants to update the <updatedTitle> in the todos details
    And    System can verify the new todos is add successfully
    Then   System should cleanUp new todos data
    And    System should verify that test data todos is removed successfully

    Examples:
      |user_id    | title                           |   due_on                            | status    | updatedTitle                    |
      |8          | "Amplitudo absconditus 38....." |  "2021-12-06T00:00:00.000+05:30"    | "pending" | "Amplitudo absconditus 41....." |

