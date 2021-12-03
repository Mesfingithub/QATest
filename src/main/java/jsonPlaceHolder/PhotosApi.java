package jsonPlaceHolder;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PhotosApi {
    static String urlName = "https://jsonplaceholder.typicode.com/photos/";
    static Response result = given().when().get(urlName);

    public static void main(String[] args) {
        //getAllPhotos();
        //getStatusCode();
        //getPhotoByID();
        getSomePhotos();

    }
    public static void getAllPhotos(){
        result.thenReturn().body()
                .prettyPrint();
    }
    public static void getStatusCode(){
        //int statusCode = response.thenReturn().statusCode();
        //System.out.println(statusCode);
        result.then().assertThat().statusCode(200).log().status();
    }
    public static void getPhotoByID(){
        given().when().get(urlName + "3").thenReturn().prettyPrint();
    }
    public static void getSomePhotos(){
        int []arr = {2,4,6,8};
        for(int i: arr){
            given().when().get(urlName + String.valueOf(i)).thenReturn().prettyPrint();

        }
    }
}
