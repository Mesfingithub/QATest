package jsonPlaceHolder;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class TodosApi {

    static String urlName = "https://jsonplaceholder.typicode.com/todos/";
    static Response response;

    public static void main(String[] args) {
        //getAllTodos();
        //getStatusCode();
       // getTodoByID();
        getTodosByID();


    }
    public static void getAllTodos() {
        given()
                .when()
                .get(urlName)
                .thenReturn()
                .prettyPrint();
    }
    public static void getStatusCode() {
        int StatusCode = given().when().get(urlName).thenReturn().statusCode();
        System.out.println(StatusCode);

    }
    public static void getTodoByID() {
        given().when().get(urlName + "5")
                .thenReturn().prettyPrint();
    }
    //print the album 1, 3, 5, 7 and 9 ...code??
    public static void getTodosByID() {
        int[] ids = {1, 3, 5, 7, 9};
        for (int id : ids) {

            given().when().get(urlName + id)
                    .thenReturn().prettyPrint();
        }


    }

}
