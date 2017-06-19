package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import support.AppHelper;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Claire on 2017/6/16.
 */
public class DeleteTagStepDef implements En {
    TouchAction action = new TouchAction(AppHelper.driver);
    public DeleteTagStepDef() {
//        Given("^user want to delete the tag named \"([^\"]*)\"$", (String tag) -> {
//            AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']")).click();
//            AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='Edit tags']")).click();
//        });
        Given("^user create a text note with tag \"([^\"]*)\"$", (String arg0) -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();

            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys("test");
            AppHelper.driver.findElement(By.id("note_activity_tags")).sendKeys(arg0);

            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });
        When("^user delete the tag \"([^\"]*)\"$", (String arg0) -> {
            AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='Edit tags']")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElementById("delete_button").click();
            AppHelper.driver.findElementById("button1").click();
        });
        Then("^there is no tag in the tag list$", () -> {
            String str = AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='No tags found!']")).getText();
            assertThat(str.compareTo("No tags found!"), is(0));
            AppHelper.driver.findElementById("home").click();
        });
        And("^delete the note$", () -> {
            action.longPress( AppHelper.driver.findElementById("card_main_layout") ).release().perform() ;
            AppHelper.driver.findElementById("action_delete").click();
        });

    }
}
