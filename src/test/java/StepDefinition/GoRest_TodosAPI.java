package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class GoRest_TodosAPI {
    String apiName = "https://gorest.co.in/public/v1/todos/";
    Response apiResponse;
    String headerName = "Authorization";
    String token = "Bearer deef60c87fe579169569b06a980e49f3144acfb08c4889747f6599f05d18e661";
    int id;

    @Given("Todos api is working and returning {int} status code")
    public void todos_api_is_working_and_returning_status_code(int statusCode) {
        int responseCode = given().when().get(apiName).thenReturn().statusCode();
        assertEquals(responseCode, statusCode);

    }
    @When("User wants to add new Todos with {int},{string},{string} and {string}")
    public void todos_wants_to_add_new_todos_with_and(Integer user_id, String title, String due_on, String status) {
        JSONObject todos = new JSONObject();
        todos.put("user_id",user_id);
        todos.put("title",title);
        todos.put("due_on",due_on);
        todos.put("status",status);

        apiResponse = given().header(headerName,token)
                .contentType(ContentType.JSON)
                .and().body(todos)
                .when().post(apiName);

        assertEquals(201, apiResponse.statusCode());
        id = apiResponse.jsonPath().getInt("data.id");

    }
    @When("System can verify the new todos is add successfully")
    public void system_can_verify_the_new_todos_is_add_successfully() {
        assertEquals(200,given().when().get(apiName + id).statusCode());

    }
    @Then("System should cleanUp new todos data")
    public void system_should_clean_up_new_todos_data() {
        int deleteStat = given().header(headerName,token)
                .when().delete(apiName + id).thenReturn().statusCode();
        assertEquals(204,deleteStat);

    }
    @Then("System should verify that test data todos is removed successfully")
    public void system_should_verify_that_test_data_todos_is_removed_successfully() {
        assertEquals(404, given().when().get(apiName + id).statusCode());
    }
    @Then("User wants to update the {string} in the todos details")
    public void user_wants_to_update_the_in_the_todos_details(String updatedTitle) {
        JSONObject updatedTodos = new JSONObject();
        updatedTodos.put("title",updatedTitle);
        apiResponse = given().header(headerName,token)
                .contentType(ContentType.JSON)
                .and().body(updatedTodos)
                .when().put(apiName + id);
        assertEquals(200,apiResponse.statusCode());

    }


    }
