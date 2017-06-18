package steps;

import cucumber.api.java8.En;
import org.openqa.selenium.By;
import support.AppHelper;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by Claire on 2017/6/16.
 */
public class DeleteTagStepDef implements En {
    public DeleteTagStepDef() {
        Given("^user want to delete the tag named \"([^\"]*)\"$", (String tag) -> {
            AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='Edit tags']")).click();
        });
        When("^user delete the tag$", () -> {
            AppHelper.driver.findElementById("delete_button").click();
            AppHelper.driver.findElementById("button1").click();
        });
        Then("^there is no tag \"([^\"]*)\" in the tag list$", (String tag) -> {
            String str = AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='No tags found!']")).getText();
            assertThat(str.compareTo("No tags found!"), is(0));
        });
    }
}
