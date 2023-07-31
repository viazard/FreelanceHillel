package Pages;

import Navigate.ButtonsValue;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;

public class LoginPage extends ButtonsValue {
    public void loginPage(String userName, String password) {
        open("/login");

        setUserName.click();
        setUserName.sendKeys(userName);
        setPassword.click();
        setPassword.sendKeys(password);

        loginButton.should(Condition.visible).shouldNot(Condition.disabled).click();

    }
    public void profileMainPage(){

        profileButton.click();
        dropMenu.should(Condition.exist).shouldBe(Condition.visible);
        profileMenu.click();
    }

    public String getTitle(){
        return welcomeLoginPage.getText();
    }
}
