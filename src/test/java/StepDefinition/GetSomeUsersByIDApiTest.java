package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetSomeUsersByIDApiTest {
    static String urlName = "https://jsonplaceholder.typicode.com/users/";
    static Response result;

    @Given("User sets the base api request url globally-GetSomeUserByID")
    public void user_sets_the_base_api_request_url_globally_get_some_user_by_id() {

        result=given().when().get(urlName);
    }
    @When("User sends the api request to get some users by their usersID number")
    public void user_sends_the_api_request_to_get_some_users_by_their_users_id_number() {
        int [] ids = {2, 4, 6, 8, 9};
        for (int id: ids) {

            given().when().get(urlName + id)
                    .thenReturn().prettyPrint();
        }

    }
    @Then("User validates the response and the status code accordingly")
    public void user_validates_the_response_and_the_status_code_accordingly() {
        result.then().assertThat().statusCode(200).log().status();

    }
}
