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
            throw new PendingException();
//            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });

        Then("^there is a new text note which the title is \"([^\"]*)\", and the content is \"([^\"]*)\" in the sealnote$", (String title, String content) -> {
            throw new PendingException();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            AppHelper.driver.findElementById("list_cardId").click();
////
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys(title+"123");
//            String actualTitle = AppHelper.driver.findElement(By.).getText();
//            WebElement titleEle = AppHelper.driver.findElementByXPath("//android.widget.EditText[@resource-id='note_activity_title']");//findElement(By.id("note_activity_title"));
//            WebElement contentEle = AppHelper.driver.findElement(By.id("note_activity_note"));
//            String actualTitle = titleEle.getAttribute("text");
//            String actualContent = contentEle.getText();
//            assertThat(actualTitle, is(title));
//            assertThat(actualContent, is(content));
//            AppHelper.driver.findElementByXPath("//android.widget.AbsListView[@resource-id='notes_view']/android.widget.LinearLayout[@index='0']").click();
//            if ( AppHelper.driver.findElement(By.id("card_header_inner_simple_title")).isDisplayed() ) {
//                String actualTitle = AppHelper.driver.findElement(By.xpath("//android.widget.AbsListView[@resource-id='notes_view'][1]//android.widget.TextView[resource-id='card_header_inner_simple_title']")).getText();
////                String actualTitle = AppHelper.driver.findElement(By.id("card_header_inner_simple_title")).getText();
//                String actualContent = AppHelper.driver.findElement(By.id("cardcontent_note")).getText();
//                assertThat(actualTitle, is(title));
//                assertThat(actualContent, is(content));
//            }
        });

        Then("^there is a new note which the title is \"([^\"]*)\", the name is \"([^\"]*)\", the card number \"([^\"]*)\", valid from \"([^\"]*)\" to \"([^\"]*)\" and cvv is \"([^\"]*)\" in the sealnote$", (String title, String name, String number, String startDate, String endDate, String cvv) -> {
            throw new PendingException();
//            AppHelper.driver.findElement(By.id("card_main_layout")).click();
////            String actualTitle = AppHelper.driver.findElement(By.id("note_activity_title")).getText() ;
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
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });

    }
}
