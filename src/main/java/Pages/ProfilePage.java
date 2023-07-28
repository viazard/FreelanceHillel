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

    public void setNewName(String newName){
        setProfileNewName.click();
        setProfileNewName.clear();
        setProfileNewName.sendKeys(newName);
    }
    public void setNewLastName(String newLastName){
        setProfileNewLastName.click();
        setProfileNewLastName.clear();
        setProfileNewLastName.sendKeys(newLastName);
    }

    public void updateUserNameInfo(){

        btnSubmitUpdateUserProfile.click();
    }

    public String checkUpdateTitleUser(){

        return titleName.getText();
    }

    public String checkUpdateMainUserInfo() {

        return updatedProfileName.getText();
    }

    public String getTitle(){

        return welcomProfilePage.getText();
    }
}
