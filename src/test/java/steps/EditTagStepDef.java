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
        Given("^user want to edit the tag on the top of the tag list$", () -> {
            AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='Edit tags']")).click();
        });
        When("^user edit the tag to \"([^\"]*)\"$", (String arg0) -> {
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElementById("text1").click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElementById("input_rename").clear();
            AppHelper.driver.findElementById("input_rename").sendKeys(arg0);
            AppHelper.driver.findElementById("button1").click();
        });
        Then("^the tag \"([^\"]*)\" is in the tag list$", (String arg0) -> {
            String newTag = AppHelper.driver.findElementById("text1").getText() ;
            assertThat(newTag, is(arg0));
            AppHelper.driver.findElementById("home").click();
        });
    }
}
