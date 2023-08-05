package Api.AuthControllerTest;

import Api.POJOClasses.AuthController.SignInSuccess;
import Api.POJOClasses.UserController.UserControllerApiUser;
import Api.UserController.UserController;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AuthControllerTest {
    private String userName = "Kylee";
    private String password = "123456789";
    private static ThreadLocal<String> tokenAuth = new ThreadLocal<>();

    @Test (priority = 1)
    public void userSignup() throws IOException, ClassNotFoundException {
        Faker faker = new Faker();
        String fakerName = faker.name().firstName();
        String fakerPassword = "123456789";
        String messageExpected = "User registered successfully";

        AuthController authController = new AuthController();
        String messageActual = authController.signUp(fakerName, fakerPassword);

        Assert.assertEquals(messageActual, messageExpected, "User doesn't registered");

    }

    @Test (priority = 2)
    public void userSignin() throws Exception {

        AuthController authController = new AuthController();
        String token = authController.signIn(userName, password);

        String[] tokenAuthNotB = token.split("\\s");
        tokenAuth.set(tokenAuthNotB[1]);

        Assert.assertNotNull(tokenAuth, "Token is empty");

    }

    @Test (priority = 3)
    public void userController() throws Exception {

        UserController userController = new UserController();
        userController.getCurrentUser(tokenAuth.get());

        UserControllerApiUser userControllerApiUser = new UserControllerApiUser();
    }

/*    @Test (priority = 4)
    public void exempleUser(){
        System.out.println("My share token2: " + tokenLocal.get());
    }*/
}
