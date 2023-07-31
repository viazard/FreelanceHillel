package Pages;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;


public class PagesTest {

    //Checks access links for login and register pages
    @Test (priority = 1)
    public void homePage(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";
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

    //Check if user can register on page
    @Test (priority = 2)
    public void registerPage(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";

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


    //Check, if user can go his profile and can changes name and Last name
    @Test (priority = 3)
    public void editProfilePage(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";

        LoginPage loginPage = new LoginPage();
        loginPage.loginPage("Dusty Carr", "123456789");

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

    //Check, if user can add Job on his Jobs board
    @Test (priority = 4)
    public void addNewAdOnMyJobsPage(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";

        ProfilePage profilePage = new ProfilePage();
        profilePage.afterLoginedPage();

        AdPage adPage = new AdPage();
        adPage.newAd();
        String newTitleAdJob = "New QA111";
        adPage.titleAdJob(newTitleAdJob);
        adPage.descriptionAdJob("Create test cases for new project");
        adPage.priceAdJob("500");

        adPage.createJob();
        System.out.println(adPage.createdNewJob());

        if(adPage.createdNewJob() == newTitleAdJob){
            throw new RuntimeException(
                    "Ad is not added on desk"
            );
        }
    }

    //Check, if user can go to main Job board, can view details of Job and leave comments
    @Test (priority = 5)
    public void editAdOnMainJobsPage(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";

        AdMainPage adMainPage = new AdMainPage();
        adMainPage.openAdMainPage();
        adMainPage.checkLoadMainAdPAge();

        adMainPage.viewAdInfo();
        adMainPage.inputCommentToAd("Message for e.g");

        adMainPage.leaveCommentToAd();
        adMainPage.closeJobDetailes();
    }

    //Check, if user can see how many comments leaved for each Job and can remove job from his Job board
    @Test (priority = 6)
    public void removeMyJobs(){
        Configuration.baseUrl= "https://freelance.lsrv.in.ua";

        LoginPage loginPage = new LoginPage();
        loginPage.profileMainPage();

        AdPage adPage = new AdPage();
        adPage.countJobsList();
        if(adPage.countJobsList().isEmpty()){
            throw new RuntimeException("You haven't list of your jobs");
        } else {
            System.out.println(adPage.countJobsList());
        }

        if (adPage.listCardJobs() == 0){
            throw new RuntimeException("You have zero ad of jobs");
        } else {
            adPage.countComments();
        }

        Random random = new Random();
        int numberOfJobCard = (int) (random.nextInt(adPage.listCardJobs()));
        adPage.deleteJob(numberOfJobCard);
    }

}
