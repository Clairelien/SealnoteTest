package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import support.AppHelper;

/**
 * Created by Claire on 2017/6/12.
 */
public class CreateNewLoginNoteStepDef implements En {
    public CreateNewLoginNoteStepDef() {

        Given("^user want to new a login note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView//android.widget.LinearLayout[@index='2']//android.widget.TextView")).click();
        });
        And("^user is editing a new note which the url is \"([^\"]*)\", the login account is \"([^\"]*)\" and the password is \"([^\"]*)\"$", (String url, String acc, String pwd) -> {
            AppHelper.driver.findElement(By.id("note_login_url")).sendKeys(url);
            AppHelper.driver.findElement(By.id("note_login_name")).sendKeys(acc);
            AppHelper.driver.findElement(By.id("note_login_password")).sendKeys(pwd);
        });
        When("^user submit the login note$", () -> {
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });
        Then("^there is a new login note which the url is \"([^\"]*)\", the login account is \"([^\"]*)\" and the password is \"([^\"]*)\" in the sealnote$", (String url, String acc, String pwd) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
