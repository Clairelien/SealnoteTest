package steps;

import cucumber.api.java8.En;
import org.openqa.selenium.By;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebElement;
import support.AppHelper;
import java.util.AbstractList;

/**
 * Created by Claire on 2017/6/2.
 */
public class CreateNewTextNoteStepDef implements En{

    public CreateNewTextNoteStepDef() {

        Given("^user want to new a text note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();
        });

        And("^user is editing a new note which the title is \"([^\"]*)\", and the content is \"([^\"]*)\"$", (String title, String content) -> {

            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys(title);
            AppHelper.driver.findElement(By.id("note_activity_note")).sendKeys(content);
        });

        When("^user submit the text note$", () -> {
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });

        Then("^there is a new text note which the title is \"([^\"]*)\", and the content is \"([^\"]*)\" in the sealnote$", (String title, String content) -> {

            if ( AppHelper.driver.findElement(By.id("card_header_inner_simple_title")).isDisplayed() ) {
                String actualTitle = AppHelper.driver.findElement(By.id("card_header_inner_simple_title")).getText();
                String actualContent = AppHelper.driver.findElement(By.id("cardcontent_note")).getText();
                assertThat(actualTitle, is(title));
                assertThat(actualContent, is(content));
            }
        });

    }
}
