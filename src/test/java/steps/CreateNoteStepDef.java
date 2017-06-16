package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.openqa.selenium.By;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.WebElement;
import support.AppHelper;
import java.util.AbstractList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Claire on 2017/6/2.
 */
public class CreateNoteStepDef implements En{

    public CreateNoteStepDef() {

        Given("^user want to new a text note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();
        });

        Given("^user want to new a empty text note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();
        });

        Given("^user want to new a card note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView//android.widget.LinearLayout[@index='1']//android.widget.TextView")).click();
        });

        Given("^user want to new a login note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView//android.widget.LinearLayout[@index='2']//android.widget.TextView")).click();
        });

        And("^user is editing a new note which the title is \"([^\"]*)\", and the content is \"([^\"]*)\"$", (String title, String content) -> {
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys(title);
            AppHelper.driver.findElement(By.id("note_activity_note")).sendKeys(content);
//            AppHelper.driver.findElementById("action_color").click();
//            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//            AppHelper.driver.findElementByXPath("//android.widget.GridView/android.widget.FrameLayout[@index='1']").click();
        });

        And("^user is editing a new card which the title is \"([^\"]*)\", the name is \"([^\"]*)\", the card number \"([^\"]*)\", valid from \"([^\"]*)\" to \"([^\"]*)\" and cvv is \"([^\"]*)\"$", (String title, String name, String number, String startDate, String endDate, String cvv) -> {
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys(title);
            AppHelper.driver.findElement(By.id("note_card_name")).sendKeys(name);
            AppHelper.driver.findElement(By.id("note_card_number")).sendKeys(number);
            AppHelper.driver.findElement(By.id("note_card_valid_from")).sendKeys(startDate);
            AppHelper.driver.findElement(By.id("note_card_valid_upto")).sendKeys(endDate);
            AppHelper.driver.findElement(By.id("note_card_cvv")).sendKeys(cvv);
        });

        And("^user is editing a new note which the url is \"([^\"]*)\", the login account is \"([^\"]*)\" and the password is \"([^\"]*)\"$", (String url, String acc, String pwd) -> {
            AppHelper.driver.findElement(By.id("note_login_url")).sendKeys(url);
            AppHelper.driver.findElement(By.id("note_login_name")).sendKeys(acc);
            AppHelper.driver.findElement(By.id("note_login_password")).sendKeys(pwd);
        });

        When("^user submit the note$", () -> {
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });

        Then("^there is a new text note which the title is \"([^\"]*)\", and the content is \"([^\"]*)\" in the sealnote$", (String title, String content) -> {
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            assertThat( AppHelper.driver.findElementById("card_header_inner_simple_title").getText(), is(title)) ;
            assertThat( AppHelper.driver.findElementById("cardcontent_note").getText(), is(content)) ;
        });

        Then("^there is no new text note in the sealnote$", () -> {

        });

        Then("^there is a new note which the title is \"([^\"]*)\", the name is \"([^\"]*)\", the card number \"([^\"]*)\", valid from \"([^\"]*)\" to \"([^\"]*)\" and cvv is \"([^\"]*)\" in the sealnote$", (String title, String name, String number, String startDate, String endDate, String cvv) -> {

            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            assertThat(AppHelper.driver.findElement(By.xpath("//android.widget.EditText[@text='my card' and @index='0' and @resource-id='note_card_name']")).getAttribute("text"), is(name));
//            String actualTitle = AppHelper.driver.findElement(By.id("note_activity_title")).getText() ;
//            String actualName = AppHelper.driver.findElement(By.id("note_card_name")).getText() ;
//            String actualNumber = AppHelper.driver.findElement(By.id("note_card_number")).getText() ;
//            String actualStartDate = AppHelper.driver.findElement(By.id("note_card_valid_from")).getText() ;
//            String actualEndDate = AppHelper.driver.findElement(By.id("note_card_valid_upto")).getText() ;
//            String actualCvv = AppHelper.driver.findElement(By.id("note_card_cvv")).getText() ;
////            assertThat(actualTitle, is(title)) ;
//            assertThat(actualName, is(name)) ;
//            assertThat(actualNumber, is(number)) ;
//            assertThat(actualStartDate, is(startDate)) ;
//            assertThat(actualEndDate, is(endDate)) ;
//            assertThat(actualCvv, is(cvv)) ;
        });

        Then("^there is a new login note which the url is \"([^\"]*)\", the login account is \"([^\"]*)\" and the password is \"([^\"]*)\" in the sealnote$", (String url, String acc, String pwd) -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            assertThat(AppHelper.driver.findElement(By.id("note_login_url")).getText(), is(url));
        });



    }
}
