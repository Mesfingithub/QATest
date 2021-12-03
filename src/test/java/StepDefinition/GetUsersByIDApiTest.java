package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class GetUsersByIDApiTest {
    static String urlName = "https://jsonplaceholder.typicode.com/users/";
    static Response result;

    @Given("User sets the base api request url globally")
    public void user_sets_the_base_api_request_url_globally() {
        result=given().when().get(urlName);

    }
    @When("User sends the api request to get users by their userID number")
    public void user_sends_the_api_request_to_get_users_by_their_user_id_number() {
        given().when().get(urlName + "6")
                .thenReturn().prettyPrint();

    }
    @Then("User validates the response and the status code")
    public void user_validates_the_response_and_the_status_code() {
        result.then().assertThat().statusCode(200).log().status();

    }


}
