package Test;

import Base.BasePage;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Constants.Constants.*;

public class SignInTest extends BasePage {

    @BeforeClass
    public void beforeTest() {
        setUp();
    }

    @Test
    public void successfulSignIn() {
        Response response = post(MY_USER_MAIL, MY_USER_PW, SIGN_IN_PATH);
        int statusCode = response.getStatusCode();
        String access_token = extractStringResponse(response, "access_token");
        Assert.assertEquals(access_token.length(), 188);
        Assert.assertEquals(statusCode /*actual value*/, 201 /*expected value*/, "Correct status code returned");
    }

    @Test
    public void passwordCheck() {
        for (int i = 0; i <= 3; i++) {
            Response response = post(MY_USER_MAIL, randomPasswordGenerator(i * 7), SIGN_IN_PATH);
            int statusCode = response.getStatusCode();
            String message = extractStringResponse(response, "message");
            Assert.assertEquals(message, MESSAGE_UNAUTH);
            Assert.assertEquals(statusCode /*actual value*/, 401 /*expected value*/, "Correct status code returned");
        }
    }

    @Test
    public void emptyEmail() {
        Response response = post("", MY_USER_PW, SIGN_IN_PATH);
        int statusCode = response.getStatusCode();
        String message = extractStringResponse(response, "message");
        Assert.assertEquals(message, MESSAGE_UNAUTH);
        Assert.assertEquals(statusCode /*actual value*/, 401 /*expected value*/, "Correct status code returned");
    }

    @Test
    public void bothEmpty() {
        Response response = post("", "", SIGN_IN_PATH);
        int statusCode = response.getStatusCode();
        String message = extractStringResponse(response, "message");
        Assert.assertEquals(message, MESSAGE_UNAUTH);
        Assert.assertEquals(statusCode /*actual value*/, 401 /*expected value*/, "Correct status code returned");
    }

    @Test
    public void invalidMail() {
        Response response = post("aykutdenizci", MY_USER_PW, SIGN_IN_PATH);
        int statusCode = response.getStatusCode();
        String message = extractStringResponse(response, "message");
        Assert.assertEquals(message, MESSAGE_UNAUTH);
        Assert.assertEquals(statusCode /*actual value*/, 401 /*expected value*/, "Correct status code returned");
    }

    @Test
    public void notSignUpMail() {
        Response response = post(randomMailGenerator(), MY_USER_PW, SIGN_IN_PATH);
        int statusCode = response.getStatusCode();
        String message = extractStringResponse(response, "message");
        Assert.assertEquals(message, MESSAGE_UNAUTH);
        Assert.assertEquals(statusCode /*actual value*/, 401 /*expected value*/, "Correct status code returned");
    }

}
