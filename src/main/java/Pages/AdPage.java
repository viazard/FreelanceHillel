package Pages;

import Navigate.ButtonsValue;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;

public class AdPage extends ButtonsValue {

    public void newAd() {
        btnAddJob.click();
        informCreateJob.should(Condition.exist).shouldBe(Condition.visible);
    }

    public void titleAdJob(String adJob) {
        titleAdJob.click();
        titleAdJob.clear();
        titleAdJob.sendKeys(adJob);
    }

    public void descriptionAdJob(String description) {

        descriptionAdJob.click();
        descriptionAdJob.clear();
        descriptionAdJob.sendKeys(description);
    }

    public void priceAdJob(String price) {
        priceAdJob.click();
        priceAdJob.clear();
        priceAdJob.sendKeys(price);
    }

    public void createJob(){

        btnCreateJob.click();
    }

    public String createdNewJob(){
        return addedLastJob.getText();
    }

}

