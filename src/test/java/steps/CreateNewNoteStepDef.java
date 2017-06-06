package steps;

import cucumber.api.java8.En;
import org.openqa.selenium.By;

import static org.hamcrest.core.Is.is;

import support.AppHelper;

/**
 * Created by Claire on 2017/6/2.
 */
public class CreateNewNoteStepDef implements En{

    public CreateNewNoteStepDef() {

        Given("^user is editing a new note which the title is \"([^\"]*)\", and the content is \"([^\"]*)\"$", (String title, String content) -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys(title);
            AppHelper.driver.findElement(By.id("note_activity_note")).sendKeys(content);
        });

        When("^user submit the note$", () -> {
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });

        Then("^there is a new note which the title is \"([^\"]*)\", and the content is \"([^\"]*)\" in the sealnote$", (String title, String arg1) -> {
            System.out.println("then");
//            /*String actualTitle = */AppHelper.driver.findElement(By.xpath("//android.widget.AbsListView[1]")).click();
//            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys();
//            AppHelper.driver.findElement(By.id("action_save_note")).click();
//            assertThat(actualTitle, is(title));
            //String actualTitle = AppHelper.driver.findElement(By.xpath("//android.widget.LinearLayout[resource-id='list_cardId']"))
        });

    }
}
