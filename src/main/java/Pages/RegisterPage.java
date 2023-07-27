package Pages;

import Navigate.ButtonsValue;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class RegisterPage extends ButtonsValue {

    public void registerPage(){
        open("/register");

        Faker faker = new Faker();
        String fakerName = faker.name().firstName();
        String fakerLastName = faker.name().lastName();
        String fakerUserName = faker.funnyName().name();
        Integer fakerPassword = 123456789;

        System.out.println("Login: " + fakerUserName);

        setUserName.click();
        setUserName.sendKeys(fakerUserName);

        setName.click();
        setName.sendKeys(fakerName);

        setLastName.click();
        setLastName.sendKeys(fakerLastName);

        setPassword.click();
        setPassword.sendKeys(fakerPassword.toString());

        confirmPassword.click();
        confirmPassword.sendKeys(fakerPassword.toString());

        registerButton.shouldBe(Condition.enabled).click();

    }

    public String getTitle(){
        return welcomRegisterPage.getText();
    }
}
