package Pages;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PagesTest {

    @Test (priority = 1)
    public void homePage(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";
        //Configuration.holdBrowserOpen = true;
        HomePage homePage = new HomePage();
        homePage.homePage();

        Assert.assertEquals(homePage.getTitle(), "Welcome to Freelance test app",
                "Home page didn't loaded");

        homePage.homeLoginPage();
        Assert.assertEquals(homePage.getTitleLogin(), "Login",
                "Login page didn't loaded");

        homePage.homeRegisterPage();
        Assert.assertEquals(homePage.getTitleRegister(), "Register",
                "Register page didn't loaded");

    }

    @Test (priority = 2)
    public void registerPage(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";
        //Configuration.holdBrowserOpen = true;

        RegisterPage registerPage = new RegisterPage();
        registerPage.registerPage();

        Assert.assertEquals(registerPage.getTitle(), "Register",
                "Register page didn't loaded");
    }


    @Test (priority = 3)
    public void loginPage(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";
        //Configuration.holdBrowserOpen = true;
        LoginPage loginPage = new LoginPage();
        loginPage.loginPage();

        Assert.assertEquals(loginPage.getTitle(), "Login",
                "Login page didn't loaded");

        ProfilePage profilePage = new ProfilePage();
        profilePage.afterLoginedPage();

        Assert.assertEquals(profilePage.getTitle(), "Profile",
                "Profile page didn't loaded");

        profilePage.profileEditPage();
        profilePage.setNewName();
        profilePage.setNewLastName();
        profilePage.updateUserNameInfo();

        Assert.assertEquals(profilePage.checkUpdateTitleUser(), "Love Bogan",
                "User info doesn't updated");

        Assert.assertEquals(profilePage.checkUpdateMainUserInfo(), "Love Bogan",
                "Main user info doesn't updated");


    }

}
