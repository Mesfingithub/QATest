package jsonPlaceHolder;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class AlbumsApi {

    static String urlName = "https://jsonplaceholder.typicode.com/albums/";
    static Response response;

    public static void main(String[] args) {
        // getAllAlbums();
        // getStatusCode();
        // getAlbumByID();
        getAlbumsByID();

    }

    public static void getAllAlbums() {
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

    public static void getAlbumByID() {
        given().when().get(urlName + "4")
                .thenReturn().prettyPrint();
    }

    //print the album 1, 3, 5, 7 and 9 ...code??
    public static void getAlbumsByID() {
        int[] ids = {1, 3, 5, 7, 9};
        for (int id : ids) {

            given().when().get(urlName + id)
                    .thenReturn().prettyPrint();
        }


    }
}
