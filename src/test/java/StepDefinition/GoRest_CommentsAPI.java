package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;


public class GoRest_CommentsAPI {
    String apiName = "https://gorest.co.in/public/v1/comments/";
    Response apiResponse;
    String headerName = "Authorization";
    String token = "Bearer deef60c87fe579169569b06a980e49f3144acfb08c4889747f6599f05d18e661";
    int id;

    @Given("Comments api is working and returning {int} status code")
    public void comments_api_is_working_and_returning_status_code(int statusCode) {
        int responseCode = given().when().get(apiName).thenReturn().statusCode();
        assertEquals(responseCode, statusCode);

    }
    @When("User wants to add new Comments with {int},{string},{string} and {string}")
    public void user_wants_to_add_new_comments_with_and(int post_id, String name, String email, String body) {
        JSONObject Comments = new JSONObject();
        Comments.put("post_id",post_id);
        Comments.put("name",name);
        Comments.put("email",email);
        Comments.put("body",body);


        apiResponse = given().header(headerName,token)
                .contentType(ContentType.JSON)
                .and().body(Comments)
                .when().post(apiName);
        assertEquals( apiResponse.statusCode(),201);
        id = apiResponse.jsonPath().getInt("data.id");

    }
    @When("System can verify the new comments is add successfully")
    public void system_can_verify_the_new_comments_is_add_successfully() {
        assertEquals(given().when().get(apiName + id).statusCode(),200);

    }
    @Then("System should cleanUp new comments data")
    public void system_should_clean_up_new_comments_data() {
        int deleteStat = given().header(headerName,token)
                .when().delete(apiName + id).thenReturn().statusCode();
        assertEquals(deleteStat,204);

    }
    @Then("System should verify that test data comments is removed successfully")
    public void system_should_verify_that_test_data_comments_is_removed_successfully() {
        assertEquals( given().when().get(apiName + id).statusCode(),404);

    }
    @Then("User wants to update the {string} in the comments details")
    public void user_wants_to_update_the_in_the_comments_details(String UpdatedEmail) {
        JSONObject updatedComments = new JSONObject();
//        updatedComments.put("email",updatedEmail);
        apiResponse = given().header(headerName,token)
                .contentType(ContentType.JSON)
                .and().body(updatedComments)
                .when().put(apiName + id);
        assertEquals(apiResponse.statusCode(),200);

    }
}
