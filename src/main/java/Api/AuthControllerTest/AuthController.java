package Api.AuthControllerTest;


import io.restassured.http.ContentType;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static io.restassured.RestAssured.given;

public class AuthController {
    private static final String URL = "https://freelance.lsrv.in.ua";

    public void signUp(String fakerName, String fakerPassword) throws IOException {
        UserSignUp userSignUp = new UserSignUp();
        userSignUp.setUsername(fakerName);
        userSignUp.setPassword(fakerPassword);
        userSignUp.setConfirmPassword(fakerPassword);

        SignInSuccess signInSuccess = given()
                .body(userSignUp)
                .when()
                .contentType(ContentType.JSON)
                .post(URL + "/api/auth/signup")
                .then().log().all()
                .extract().as(SignInSuccess.class);

        FileOutputStream fos = new FileOutputStream("result.bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(signInSuccess.getMessage());

        oos.close();
    }

    public String signIn (String userName, String password) throws IOException {
        UserSignIn userSignInCred = new UserSignIn();

        userSignInCred.setUsername(userName);
        userSignInCred.setPassword(password);

        String token = given()
                .body(userSignInCred)
                .when()
                .contentType(ContentType.JSON)
                .post(URL+"/api/auth/signin")
                .then()
                .extract().body().jsonPath().get("token");

        return token;
    }
}
