package steps;

import cucumber.api.java8.En;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import support.AppHelper;

/**
 * Created by Claire on 2017/6/12.
 */
public class DeleteTextNoteStepDef implements En {
    TouchAction action = new TouchAction(AppHelper.driver);
    public DeleteTextNoteStepDef() {
        Given("^user select the latest text note$", () -> {
            AppHelper.driver.findElementById("card_main_layout").click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']")).click();
        });
        When("^user delete this note$", () -> {
            //AppHelper.driver.findElementByClassName("android.widget.ImageButton");//.findElementByXPath("//android.widget.FrameLayout[@resource-id='action_bar_container']/android.view.ViewGroup/android.widget.LinearLayout[@index='1']/android.widget.ImageButton");//.findElementByAndroidUIAutomator("new UiSelecor().description(\"More options\")").click();
            System.out.println("when");
        });
        Then("^user can see the text note in the trash section$", () -> {
            System.out.println("then");

        });
    }
}
