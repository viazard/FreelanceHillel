package Pages;

import Navigate.ButtonsValue;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;

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

    public void countComments(){
        for (int i = 0; i < listJobCards.size(); i++){
            System.out.println("Job " + listJobTitle.get(i).getText() + " have " + listOfCommentsForJobs.get(i).getText());
        }
    }

    public void deleteJob(int numberOfJobCard){
        btnDeleteJob.get(numberOfJobCard).click();
        switchTo();
    }

    public static void switchTo(){
        Selenide.switchTo().alert().accept();
    }
    public int listCardJobs(){
        return listJobCards.size();
    }

    public String countJobsList(){
        return countJobsList.getText();
    }

    public String createdNewJob(){

        return addedLastJob.getText();
    }

}

