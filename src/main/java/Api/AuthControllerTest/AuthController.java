package Api.AuthControllerTest;

import Api.POJOClasses.AuthController.UserSignIn;
import Api.POJOClasses.AuthController.UserSignUp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import java.io.IOException;

import static Api.Statuses.Statuses.STATUS_OK;
import static io.restassured.RestAssured.given;

public class AuthController {
    private static final String URL = "https://freelance.lsrv.in.ua";

    public String signUp(String fakerName, String fakerPassword) throws IOException {
        UserSignUp userSignUp = new UserSignUp();

        userSignUp.setUsername(fakerName);
        userSignUp.setPassword(fakerPassword);
        userSignUp.setConfirmPassword(fakerPassword);


        String message = given()
                .body(userSignUp)
                .when()
                .contentType(ContentType.JSON)
                .post(URL + "/api/auth/signup")
                .then().log().body()
                .extract().body().jsonPath().get("message");

        return message;
    }

    public String signIn (String userName, String password) throws Exception {
        UserSignIn userSignInCred = new UserSignIn();

        userSignInCred.setUsername(userName);
        userSignInCred.setPassword(password);

        Response response = given()
                .body(userSignInCred)
                .when()
                .contentType(ContentType.JSON)
                .post(URL + "/api/auth/signin");

        if (response.getStatusCode() != STATUS_OK) {
            throw new Exception("User is not logged, error CODE: " + response.getStatusCode());
        }

        return response.getBody().jsonPath().get("token").toString();
    }
}
