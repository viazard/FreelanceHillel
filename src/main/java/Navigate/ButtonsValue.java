package Navigate;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ButtonsValue {
    //Home page
    public SelenideElement loginLink = $x("//a[@href='/login']");
    public SelenideElement registrationLink = $x("//a[@href='/register']");

    //Login page
    public SelenideElement welcomeHomePage = $x("//h4");
    public SelenideElement welcomeLoginPage = $x("//h2");
    public SelenideElement welcomRegisterPage = $x("//h2");
    public SelenideElement welcomProfilePage = $x("//h1");
    public SelenideElement updatedProfileName = $x("//h2");
    public SelenideElement titelName = $x("//h3[@class='ng-star-inserted']");

    public SelenideElement setUserName = $x("//input[@formcontrolname='username']");
    public SelenideElement setName = $x("//input[@formcontrolname='name']");
    public SelenideElement setLastName = $x("//input[@formcontrolname='lastname']");
    public SelenideElement setPassword = $x("//input[@formcontrolname='password']");
    public SelenideElement confirmPassword = $x("//input[@formcontrolname='confirmPassword']");
    public SelenideElement registerButton = $x("//button");
    public SelenideElement loginButton = $x("//button");
    public SelenideElement profileButton = $x("//button[@mattooltip='Profile']");
    public SelenideElement dropMenu = $x("//button[@aria-expanded='true']");
    public SelenideElement profileMenu = $x("//button[@routerlink='/profile']");
    public SelenideElement btnEditInfo = $x("//span[text()='Edit Info']");
    public SelenideElement setProfileNewName = $x("//input[@id='mat-input-2']");
    public SelenideElement setProfileNewLastName = $x("//input[@id='mat-input-3']");
    public SelenideElement editUserProfileApp = $x("//app-edit-profile");
    public SelenideElement btnSubmitUpdateUserProfile = $x("//div[@class='row']/button[2]");



}
