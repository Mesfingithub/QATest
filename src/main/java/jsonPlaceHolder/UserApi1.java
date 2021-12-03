package jsonPlaceHolder;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class UserApi1 {
    /*
    To Do
    1. Call api
    2. send the request
    3. Get the response with status code
    4. Valid the status code
     */
    static String urlName = "https://jsonplaceholder.typicode.com/users/";
    static Response result = given().when().get(urlName);

    public static void main(String[] args) {
        getAllUsers();
        // getStatusCode();
        //getUserByID();
        //getSomeUsers();
    }
    public static void getAllUsers(){
        result.thenReturn().body()
                .prettyPrint();
    }

    public static void getStatusCode(){
        //int statusCode = response.thenReturn().statusCode();
        //System.out.println(statusCode);
        result.then().assertThat().statusCode(200).log().status();

    }
    public static void getUserByID(){

        given().when().get(urlName + "/5").thenReturn().prettyPrint();
    }

    public static void getSomeUsers(){
        int []arr = {2,4,6,8};
        for(int i: arr){
            given().when().get(urlName + String.valueOf(i)).thenReturn().prettyPrint();

        }
    }



}