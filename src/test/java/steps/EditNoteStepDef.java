package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import support.AppHelper;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Claire on 2017/6/16.
 */
public class EditNoteStepDef implements En {
    public EditNoteStepDef() {
        Given("^user select the latest text note, and the new title is \"([^\"]*)\"$", (String newTitle) -> {
            AppHelper.driver.findElementById("card_main_layout").click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys(newTitle);
        });
        When("^user edit this note and save$", () -> {
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });
        Then("^user can see the title of this note is \"([^\"]*)\"$", (String newTitle) -> {
            String actualTitle = AppHelper.driver.findElement(By.id("card_header_inner_simple_title")).getText() ;
            assertThat(actualTitle, is(newTitle));
        });
    }
}
