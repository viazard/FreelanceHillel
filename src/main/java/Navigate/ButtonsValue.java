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
    public SelenideElement titleName = $x("//h3[@class='ng-star-inserted']");
    public SelenideElement informCreateJob = $x("//h2[text()='Create Job']");
    public SelenideElement addedLastJob = $x("//app-my-jobs//mat-card[1]//mat-card-title");

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
    public SelenideElement btnSubmitUpdateUserProfile = $x("//div[@class='row']/button[2]");
    public SelenideElement btnAddJob = $x("//button[@routerlink='/profile/add-job']");
    public SelenideElement btnCreateJob = $x("//button[@class='mat-focus-indicator mat-flat-button mat-button-base mat-primary']/span[text()=' Create job ']");
    public SelenideElement titleAdJob = $x("//input[@id='mat-input-4']");
    public SelenideElement descriptionAdJob = $x("//textarea[@id='mat-input-5']");
    public SelenideElement priceAdJob = $x("//input[@id='mat-input-6']");


}
