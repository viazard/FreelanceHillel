package Api.AuthControllerTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthControllerTest {

    @Test (priority = 1)
    public void userSignup(){
        Faker faker = new Faker();
        String fakerName = faker.name().firstName();
        String fakerPassword = "123456789";
        String message = "User registered successfully";
        SignInSuccess signInSuccess = new SignInSuccess();

        AuthController authController = new AuthController();
        authController.signUp(fakerName, fakerPassword);
    }

    @Test (priority = 2)
    public void userSignin(){
        String userName = "Kylee";
        String password = "123456789";

        AuthController authController = new AuthController();
        authController.signIn(userName, password);
    }
}
