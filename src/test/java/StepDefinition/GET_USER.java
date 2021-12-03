package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class GET_USER {

    String apiURl = "https://jsonplaceholder.typicode.com/users/";
    Response apiResponse;

    @Given("System calls user api with valid url")
    public void system_calls_user_api_with_valid_url() {
        apiResponse = given().when().get(apiURl);

    }

    @When("User api return responses with status code {int}")
    public void user_api_return_responses_with_status_code(Integer statusCode) {
        int apiResponseCod = apiResponse.thenReturn().statusCode();
        System.out.println(apiResponseCod);

    }

    @Then("System should validate api response with list of users")
    public void system_should_validate_api_response_with_list_of_users() {
        for (int i = 0; i < 10; i++) {
            apiResponse.then().body("id[" +i+"]", is(i + 1));

        }
        apiResponse.then().body("name[0]",is("Leanne Graham"));
    }
}
