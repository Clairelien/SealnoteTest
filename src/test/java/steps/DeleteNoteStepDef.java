package steps;

import cucumber.api.java8.En;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.
import org.openqa.selenium.WebElement;
import support.AppHelper;

import java.util.concurrent.TimeUnit;

/**
 * Created by Claire on 2017/6/12.
 */
public class DeleteNoteStepDef implements En {
    TouchAction action = new TouchAction(AppHelper.driver);
    public DeleteNoteStepDef() {
        Given("^user select the latest text note$", () -> {
//            AppHelper.driver.findElementById("home").click();
            action.longPress( AppHelper.driver.findElementById("card_main_layout") ).release().perform() ;
        });
        When("^user delete this note$", () -> {
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElementById("action_delete").click();
        });
        Then("^user can see the text note in the trash section$", () -> {
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement homeBtn = AppHelper.driver.findElementById("home") ;
//            AppHelper.driver.findElementById("home").click();
            action.press(homeBtn).release().perform() ;
//            AppHelper.driver.findElementByXPath("//android.widget.TextView[@Text='Trash']") ;

        });
    }
}
