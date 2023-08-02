package Api.AuthControllerTest;


import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class AuthController {
    private static final String URL = "https://freelance.lsrv.in.ua";

    public void signUp(String fakerName, String fakerPassword){
        UserSignUp userSignUp = new UserSignUp();
        userSignUp.setUsername(fakerName);
        userSignUp.setPassword(fakerPassword);
        userSignUp.setConfirmPassword(fakerPassword);

        SignInSuccess signInSuccess = given()
                .body(userSignUp)
                .when()
                .contentType(ContentType.JSON)
                .post(URL+"/api/auth/signup")
                .then().log().all()
                .extract().as(SignInSuccess.class);

    }

    public void signIn (String userName, String password){
        UserSignIn userSignIn = new UserSignIn();

        userSignIn.setUsername(userName);
        userSignIn.setPassword(password);

        SignInSuccess signInSuccess = given()
                .body(userSignIn)
                .when()
                .contentType(ContentType.JSON)
                .post(URL+"/api/auth/signin")
                .then().log().all()
                .extract().as(SignInSuccess.class);

    }
}
