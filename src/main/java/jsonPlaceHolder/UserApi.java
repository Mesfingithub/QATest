package jsonPlaceHolder;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class UserApi {

    //TODO
    //1. Call API
    //2. Send the request
    //3. Get the response with status code
    //4. Validate the status code

   static String urlName = "https://jsonplaceholder.typicode.com/users/";
    static Response response;

    public static void main(String[] args) {
       // getAllUsers();
        //getStatusCode();
       // getUserByID();
        getSomeUsersByID();

    }
    public static void getAllUsers(){
        given()
                .when()
                .get(urlName)
                .thenReturn()
                .prettyPrint();
    }

    public static void getStatusCode(){
        int StatusCode = given().when().get(urlName).thenReturn().statusCode();
        System.out.println(StatusCode);

    }
    public static void getUserByID(){
        given().when().get(urlName + "6")
                .thenReturn().prettyPrint();
    }

    //print the user 2, 4, 6, 8 and 9 ...code??
    public static void getSomeUsersByID(){
        int [] ids = {2, 4, 6, 8, 9};
        for (int id: ids) {

            given().when().get(urlName + id)
                    .thenReturn().prettyPrint();
        }

    }


}
