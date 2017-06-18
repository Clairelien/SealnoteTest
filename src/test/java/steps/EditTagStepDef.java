package steps;

import cucumber.api.java8.En;
import org.openqa.selenium.By;
import support.AppHelper;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Claire on 2017/6/16.
 */
public class EditTagStepDef implements En {
    public EditTagStepDef() {

        Given("^user create a text note with tag$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();

            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys("test");
            AppHelper.driver.findElement(By.id("note_activity_tags")).sendKeys("tag");

            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });
        When("^user edit the tag to \"([^\"]*)\"$", (String arg0) -> {
            AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='Edit tags']")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElementByXPath("//android.widget.TextView[@text='tag']").click();
//            AppHelper.driver.findElementById("text1").click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElementById("input_rename").clear();
            AppHelper.driver.findElementById("input_rename").sendKeys(arg0);
            AppHelper.driver.findElementById("button1").click();
        });
        Then("^the tag \"([^\"]*)\" is in the tag list$", (String arg0) -> {
            String newTag = AppHelper.driver.findElementByXPath("//android.widget.TextView[@text='"+arg0+"']").getText() ;
            assertThat(newTag, is(arg0));
            AppHelper.driver.findElementById("home").click();
        });
    }
}
