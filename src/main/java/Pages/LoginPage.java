package Pages;

import Navigate.ButtonsValue;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends ButtonsValue {
    public void loginPage() {
        open("/login");

        setUserName.click();
        setUserName.sendKeys("Dusty Carr");
        setPassword.click();
        setPassword.sendKeys("123456789");

        loginButton.should(Condition.visible).shouldNot(Condition.disabled).click();

    }
    public void profileMainPage(){

        profileButton.click();
        dropMenu.should(Condition.exist).shouldBe(Condition.visible);
        profileMenu.click();
    }

    public void profileEditPage(){

    }

    public String getTitle(){
        return welcomeLoginPage.getText();
    }
}
