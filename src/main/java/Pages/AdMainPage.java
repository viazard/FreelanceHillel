package Pages;

import Navigate.ButtonsValue;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;

public class AdMainPage extends ButtonsValue {
    public void openAdMainPage(){
        open("/main");
    }

    public void checkLoadMainAdPAge(){
        mainAdPage.should(Condition.exist);
    }

    public void viewAdInfo(){
        btnAdViewInfo.click();
    }

    public void inputCommentToAd(String messageToAd){
        inputComment.click();
        inputComment.sendKeys(messageToAd);
    }

    public void leaveCommentToAd(){
        btnLeaveCommentToAd.should(Condition.visible).shouldNot(Condition.disabled);
        btnLeaveCommentToAd.click();
    }

    public void closeJobDetailes(){
        btnCloseJobDetailes.click();

    }
}
