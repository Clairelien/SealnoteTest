package steps;

import cucumber.api.java8.En;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import support.AppHelper;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("android:id/action_bar_title")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='Trash']")).click();

            String actualTitle = AppHelper.driver.findElement(By.id("card_header_inner_simple_title")).getText() ;
            String actualContent = AppHelper.driver.findElement(By.id("cardcontent_note")).getText() ;
            assertThat(actualTitle, is("test"));
            assertThat(actualContent, is("hello world"));
        });
    }
}
