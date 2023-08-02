package Api.AuthControllerTest;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AuthControllerTest {

    @Test (priority = 1)
    public void userSignup() throws IOException, ClassNotFoundException {
        Faker faker = new Faker();
        String fakerName = faker.name().firstName();
        String fakerPassword = "123456789";
        String messageActual = "User registered successfully";
        SignInSuccess signInSuccess = new SignInSuccess();

        AuthController authController = new AuthController();
        authController.signUp(fakerName, fakerPassword);

        FileInputStream fis = new FileInputStream("result.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        String messageExpected = (String) ois.readObject();
        ois.close();

        Assert.assertEquals(messageExpected, messageActual, "User doesn't registered");

    }

    @Test (priority = 2)
    public void userSignin() throws IOException, ClassNotFoundException {
        String userName = "Kylee";
        String password = "123456789";

        AuthController authController = new AuthController();
        authController.signIn(userName, password);

        FileInputStream fis = new FileInputStream("result.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        boolean isSuccessActual = (boolean) ois.readObject();
        String tokenActual = (String) ois.readObject();
        ois.close();

        Assert.assertTrue(isSuccessActual, "User is not logged");
        Assert.assertNotNull(tokenActual, "Token is empty");

    }
}
