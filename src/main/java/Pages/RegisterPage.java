package Pages;

import Navigate.ButtonsValue;
import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;

import static com.codeborne.selenide.Selenide.*;

public class RegisterPage extends ButtonsValue {
    public void registerUrl() {
        open("/register");
    }

    public void setUserName(String fakerUserName) {
        setUserName.click();
        setUserName.sendKeys(fakerUserName);
    }

    public void setName(String fakerName) {
        setName.click();
        setName.sendKeys(fakerName);
    }

    public void setLastName(String fakerLastName) {
        setLastName.click();
        setLastName.sendKeys(fakerLastName);
    }

    public void setPassword(Integer fakerPassword) {
        setPassword.click();
        setPassword.sendKeys(fakerPassword.toString());
    }

    public void confirmPassword(Integer fakerPassword) {
        confirmPassword.click();
        confirmPassword.sendKeys(fakerPassword.toString());
    }

    public void btnRegConfirm() {
        registerButton.shouldBe(Condition.enabled).click();

    }

    public String getTitle() {
        return welcomRegisterPage.getText();
    }
}
