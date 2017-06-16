package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import io.appium.java_client.TouchAction;
import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.AppHelper;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Claire on 2017/6/12.
 */
public class CreateTagStepDef implements En {
    TouchAction action = new TouchAction(AppHelper.driver);
    public CreateTagStepDef() {
        Given("^user want to add a new tag named \"([^\"]*)\" in the text note$", ( String tag ) -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();
            WebElement tags = AppHelper.driver.findElement(By.id("note_activity_tags")) ;
            tags.sendKeys(tag+" ");
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys("test");
            AppHelper.driver.findElement(By.id("note_activity_note")).sendKeys("hello world");
        });
        When("^user save the text note$", () -> {
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });
        Then("^user can see the new tag \"([^\"]*)\" in the tag list$", ( String tag ) -> {
            AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='Edit tags']")).click();
            WebElement tagText = AppHelper.driver.findElementById("text1") ;
            String str = tagText.getAttribute("text") ;
            System.out.println(str+"*****");
            assertThat(str, is(tag)); ;
//            action.press(tagText).release().perform() ;
//            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[@resource-id='list']/android.widget.RelativeLayout[@index='0']//android.widget.TextView[@resource-id='text1']")).getText() ;
        });
    }
}
