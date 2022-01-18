package Base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Random;

import static io.restassured.RestAssured.given;

public class BasePage {
    public void setUp(){
        RestAssured.baseURI= "https://bootcampapi.techcs.io";
    }
    public Response post(String email,String password,String path){
        return given().header("accept", "*/*")
                .contentType("application/json")
                .body("{\n" +
                        "  \"email\": \""+email+"\",\n" +
                        "  \"password\": \""+password+"\"\n" +
                        "}")
                .log().all()
                .when()
                .post(path);
    }
    public String extractStringResponse(Response response,String value){
        return (String) response.then()
                .extract().jsonPath().getMap("$").get(value);
    }
    public ArrayList<String> extractArrayListResponse(Response response, String value){
        return (ArrayList<String>) response.then()
                .extract().jsonPath().getMap("$").get(value);
    }
    public String randomMailGenerator(){
        Random random = new Random();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUWVXYZabcdefghijklmnopqrstuwvxyz0123456789".toCharArray();
        String stringRandom = "";
        for (int i = 0; i < 5; i++) {

            stringRandom = stringRandom + chars[random.nextInt(chars.length)];
        }
        String randomMail = stringRandom +"@hotmail.com";
        return randomMail;
    }
    public String randomPasswordGenerator(int size){
        Random random = new Random();
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUWVXYZabcdefghijklmnopqrstuwvxyz0123456789".toCharArray();
        String stringRandom = "";
        for (int i = 0; i < size; i++) {

            stringRandom = stringRandom + chars[random.nextInt(chars.length)];
        }
        return stringRandom ;
    }
}
