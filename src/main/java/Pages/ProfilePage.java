package Pages;

import Navigate.ButtonsValue;
import com.codeborne.selenide.Condition;

public class ProfilePage extends ButtonsValue {
    public void afterLoginedPage(){

        profileButton.click();
        dropMenu.should(Condition.exist).shouldBe(Condition.visible);
        profileMenu.click();
    }

    public void profileEditPage(){
        btnEditInfo.click();
    }

    public void setNewName(){
        setProfileNewName.click();
        setProfileNewName.clear();
        setProfileNewName.sendKeys("Love");
    }
    public void setNewLastName(){
        setProfileNewLastName.click();
        setProfileNewLastName.clear();
        setProfileNewLastName.sendKeys("Bogan");
    }

    public void updateUserNameInfo(){
        btnSubmitUpdateUserProfile.click();
    }

    public String checkUpdateTitleUser(){
        return titelName.getText();
    }

    public String checkUpdateMainUserInfo() {
        return updatedProfileName.getText();
    }

    public String getTitle(){

        return welcomProfilePage.getText();
    }
}
