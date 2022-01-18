package Test;

import Base.BasePage;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static Constants.Constants.*;


public class SignUpTest extends BasePage {
    @BeforeClass
    public void beforeTest() {
        setUp();
    }

    @Test
    public void successfulSignUp() {
        Response response = post(randomMailGenerator(), "CSPROJECT", SIGN_UP_PATH);
        int statusCode = response.getStatusCode();
        String access_token = extractStringResponse(response, "access_token");
        Assert.assertEquals(access_token.length(), 180);
        Assert.assertEquals(statusCode /*actual value*/, 201 /*expected value*/, "Correct status code returned");
    }

    @Test
    public void emptyEmail() {
        Response response = post("", "CSPROJECT", SIGN_UP_PATH);
        int statusCode = response.getStatusCode();
        String error = extractStringResponse(response, "error");
        JsonPath j = new JsonPath(response.asString());
        String emptyError = j.getString("message[0]");
        String invalidError = j.getString("message[1]");
        int size = response.jsonPath().getList("message").size();
        Assert.assertEquals(error, ERROR_BAD_REQUEST);
        Assert.assertEquals(emptyError, EMPTY_MAIL_ERROR);
        Assert.assertEquals(invalidError, INVALID_MAIL_ERROR);
        Assert.assertEquals(size, 2);
        Assert.assertEquals(statusCode /*actual value*/, 400 /*expected value*/, "Correct status code returned");
    }

    @Test
    public void emptyPassword() {
        Response response = post(randomMailGenerator(), "", SIGN_UP_PATH);
        int statusCode = response.getStatusCode();
        String error = extractStringResponse(response, "error");
        JsonPath j = new JsonPath(response.asString());
        String emptyError = j.getString("message[0]");
        String invalidError = j.getString("message[1]");
        int size = response.jsonPath().getList("message").size();
        Assert.assertEquals(error, ERROR_BAD_REQUEST);
        Assert.assertEquals(emptyError, LESS_THAN_8_PASSWORD_ERROR);
        Assert.assertEquals(invalidError, EMPTY_PASSWORD_ERROR);
        Assert.assertEquals(size, 2);
        Assert.assertEquals(statusCode /*actual value*/, 400 /*expected value*/, "Correct status code returned");
    }

    @Test
    public void bothEmpty() {
        Response response = post("", "", SIGN_UP_PATH);
        int statusCode = response.getStatusCode();
        String error = extractStringResponse(response, "error");
        ArrayList<String> message = extractArrayListResponse(response, "message");
        int size = response.jsonPath().getList("message").size();
        Assert.assertEquals(error, ERROR_BAD_REQUEST);
        Assert.assertTrue(message.contains(EMPTY_PASSWORD_ERROR));
        Assert.assertTrue(message.contains(EMPTY_MAIL_ERROR));
        Assert.assertTrue(message.contains(INVALID_MAIL_ERROR));
        Assert.assertTrue(message.contains(LESS_THAN_8_PASSWORD_ERROR));
        Assert.assertEquals(size, 4);
        Assert.assertEquals(statusCode /*actual value*/, 400 /*expected value*/, "Correct status code returned");
    }

    @Test
    public void invalidMail() {
        Response response = post("aykutdenizci", "CSPROJECT", SIGN_UP_PATH);
        int statusCode = response.getStatusCode();
        String error = extractStringResponse(response, "error");
        ArrayList<String> message = extractArrayListResponse(response, "message");
        int size = response.jsonPath().getList("message").size();
        Assert.assertEquals(error, ERROR_BAD_REQUEST);
        Assert.assertTrue(message.contains(INVALID_MAIL_ERROR));
        Assert.assertEquals(size, 1);
        Assert.assertEquals(statusCode /*actual value*/, 400 /*expected value*/, "Correct status code returned");
    }

    @Test
    public void lessThanEightChar() {
        Response response = post(randomMailGenerator(), randomPasswordGenerator(7), SIGN_UP_PATH);
        int statusCode = response.getStatusCode();
        String error = extractStringResponse(response, "error");
        ArrayList<String> message = extractArrayListResponse(response, "message");
        int size = response.jsonPath().getList("message").size();
        Assert.assertEquals(error, ERROR_BAD_REQUEST);
        Assert.assertTrue(message.contains(LESS_THAN_8_PASSWORD_ERROR));
        Assert.assertEquals(size, 1);
        Assert.assertEquals(statusCode /*actual value*/, 400 /*expected value*/, "Correct status code returned");

    }

    @Test
    public void moreThanTwentyChar() {
        Response response = post(randomMailGenerator(), randomPasswordGenerator(21), SIGN_UP_PATH);
        int statusCode = response.getStatusCode();
        String error = extractStringResponse(response, "error");
        ArrayList<String> message = extractArrayListResponse(response, "message");
        int size = response.jsonPath().getList("message").size();
        Assert.assertEquals(error, ERROR_BAD_REQUEST);
        Assert.assertTrue(message.contains(MORE_THAN_20_PASSWORD_ERROR));
        Assert.assertEquals(size, 1);
        Assert.assertEquals(statusCode /*actual value*/, 400 /*expected value*/, "Correct status code returned");
    }

    @Test
    public void signUpWithUserMail() {
        Response response = post(MY_USER_MAIL, randomPasswordGenerator(10), SIGN_UP_PATH);
        int statusCode = response.getStatusCode();
        String error = extractStringResponse(response, "error");
        String message = extractStringResponse(response, "message");
        Assert.assertEquals(error, ERROR_CONFLICT);
        Assert.assertTrue(message.contains(ALREADY_EXIST_ERROR));
        Assert.assertEquals(statusCode /*actual value*/, 409 /*expected value*/, "Correct status code returned");

    }
}
