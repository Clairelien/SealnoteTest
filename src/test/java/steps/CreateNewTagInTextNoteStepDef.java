package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import support.AppHelper;

/**
 * Created by Claire on 2017/6/12.
 */
public class CreateNewTagInTextNoteStepDef implements En {
    public CreateNewTagInTextNoteStepDef() {
        Given("^user want to add a new tag named \"([^\"]*)\" in the text note$", ( String tag ) -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.findElement(By.id("note_activity_tags")).click();//.sendKeys(tag+" ");
        });
        When("^user save the text note$", () -> {
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });
        Then("^user can see the new tag \"([^\"]*)\" in the tag list$", ( String tag ) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
