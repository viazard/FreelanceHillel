package Pages;

import Navigate.ButtonsValue;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;

public class HomePage extends ButtonsValue {
    public void homePage() {

        open("/home");
    }
    public void homeLoginPage(){
        loginLink.should(Condition.exist).click();
    }
    public void homeRegisterPage(){
        registrationLink.should(Condition.exist).click();
    }

    public String getTitle(){
        return welcomeHomePage.getText();
    }
    public String getTitleLogin(){
        return welcomeLoginPage.getText();
    }
    public String getTitleRegister(){
        return welcomRegisterPage.getText();
    }
}
