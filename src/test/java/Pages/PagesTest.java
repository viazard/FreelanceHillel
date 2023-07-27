package Pages;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PagesTest {

    @Test (priority = 1)
    public void homePage(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";
        Configuration.holdBrowserOpen = true;
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
        Configuration.holdBrowserOpen = true;

        RegisterPage registerPage = new RegisterPage();
        Faker faker = new Faker();
        String fakerName = faker.name().firstName();
        String fakerLastName = faker.name().lastName();
        String fakerUserName = faker.funnyName().name();
        Integer fakerPassword = 123456789;

        registerPage.registerUrl();
        registerPage.setName(fakerName);
        registerPage.setUserName(fakerUserName);
        registerPage.setLastName(fakerLastName);
        registerPage.setPassword(fakerPassword);
        registerPage.confirmPassword(fakerPassword);
        registerPage.btnRegConfirm();

        Assert.assertEquals(registerPage.getTitle(), "Register",
                "Register page didn't loaded");
    }


    @Test (priority = 3)
    public void loginPage(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";
        Configuration.holdBrowserOpen = true;

        LoginPage loginPage = new LoginPage();
        loginPage.loginPage();

        Assert.assertEquals(loginPage.getTitle(), "Login",
                "Login page didn't loaded");

        ProfilePage profilePage = new ProfilePage();
        profilePage.afterLoginedPage();

        Assert.assertEquals(profilePage.getTitle(), "Profile",
                "Profile page didn't loaded");

        profilePage.profileEditPage();
        profilePage.setNewName("Love");
        profilePage.setNewLastName("Bogan");
        profilePage.updateUserNameInfo();

        if (profilePage.checkUpdateTitleUser() != "Love Bogan"){
            throw new RuntimeException("Main user info doesn't updated");
        }

        if (profilePage.checkUpdateMainUserInfo() != "Love Bogan"){
            throw new RuntimeException("Main user info doesn't updated");
        }
    }

    @Test (priority = 4)
    public void adPage(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";
        Configuration.holdBrowserOpen = true;

        /*LoginPage loginPage = new LoginPage();
        loginPage.loginPage();*/

        ProfilePage profilePage = new ProfilePage();
        profilePage.afterLoginedPage();

        AdPage adPage = new AdPage();
        adPage.newAd();
        String newTitleAdJob = "New QA223";
        adPage.titleAdJob(newTitleAdJob);
        adPage.descriptionAdJob("Create test cases for new project");
        adPage.priceAdJob("500");

        adPage.createJob();

        Assert.assertEquals(adPage.createdNewJob(), newTitleAdJob,
                "Ad is not added on desk");

    }

}
