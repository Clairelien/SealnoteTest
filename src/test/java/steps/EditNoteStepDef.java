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
        Given("^user create a text note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();

            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys("test");
            AppHelper.driver.findElement(By.id("note_activity_note")).sendKeys("hello");
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });

        Given("^user create a card note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView//android.widget.LinearLayout[@index='1']//android.widget.TextView")).click();

            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys("test");
            AppHelper.driver.findElement(By.id("note_card_name")).sendKeys("my card");
            AppHelper.driver.findElement(By.id("note_card_number")).sendKeys("1234123412341234");
            AppHelper.driver.findElement(By.id("note_card_valid_from")).sendKeys("1111");
            AppHelper.driver.findElement(By.id("note_card_valid_upto")).sendKeys("1120");
            AppHelper.driver.findElement(By.id("note_card_cvv")).sendKeys("222");

            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });

        Given("^user create a login note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView//android.widget.LinearLayout[@index='2']//android.widget.TextView")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            AppHelper.driver.findElement(By.id("note_login_url")).sendKeys("google.com");
            AppHelper.driver.findElement(By.id("note_login_name")).sendKeys("hello123");
            AppHelper.driver.findElement(By.id("note_login_password")).sendKeys("123***555");
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });

        And("^turn the title to \"([^\"]*)\"$", (String title) -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_activity_title")).clear();
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys(title);
        });

        And("^turn the valid from to \"([^\"]*)\"$", (String validFrom) -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_card_valid_from")).clear();
            AppHelper.driver.findElement(By.id("note_card_valid_from")).sendKeys(validFrom);
        });

        And("^turn the password to \"([^\"]*)\"$", (String pwd) -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_login_password")).clear();
            AppHelper.driver.findElement(By.id("note_login_password")).sendKeys(pwd);
        });

        And("^clear all the blank in text note$", () -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_activity_title")).clear();
            AppHelper.driver.findElement(By.id("note_activity_note")).clear();
        });

        And("^clear all the blank in card note$", () -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_activity_title")).clear();
            AppHelper.driver.findElement(By.id("note_card_name")).clear();
            AppHelper.driver.findElement(By.id("note_card_number")).clear();
            AppHelper.driver.findElement(By.id("note_card_valid_from")).clear();
            AppHelper.driver.findElement(By.id("note_card_valid_upto")).clear();
            AppHelper.driver.findElement(By.id("note_card_cvv")).clear();
        });

        And("^clear all the blank in login note$", () -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_login_url")).clear();
            AppHelper.driver.findElement(By.id("note_login_name")).clear();
            AppHelper.driver.findElement(By.id("note_login_password")).clear();
        });

        When("^user save the note$", () -> {
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });

        Then("^user can see the title of this note is \"([^\"]*)\"$", (String newTitle) -> {
            String actualTitle = AppHelper.driver.findElement(By.id("card_header_inner_simple_title")).getText() ;
            assertThat(actualTitle, is(newTitle));
        });

        Then("^user can see the valid from of this note is \"([^\"]*)\"$", (String validFrom) -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String actualTitle = AppHelper.driver.findElement(By.id("note_card_valid_from")).getText() ;
            assertThat(actualTitle, is(validFrom));
            AppHelper.driver.findElementById("home").click();
        });

        Then("^user can see the password of this note is \"([^\"]*)\"$", (String arg0) -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            assertThat( AppHelper.driver.findElement(By.id("note_login_password")).getText(), is(arg0)) ;
            AppHelper.driver.findElementById("home").click();
        });

        Then("^the text note will not be changed$", () -> {
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            assertThat( AppHelper.driver.findElementById("card_header_inner_simple_title").getText(), is("test")) ;
            assertThat( AppHelper.driver.findElementById("cardcontent_note").getText(), is("hello")) ;
        });

        Then("^the card note will not be changed$", () -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            String actualTitle = AppHelper.driver.findElement(By.id("note_activity_title")).getText() ;
            String actualName = AppHelper.driver.findElement(By.id("note_card_name")).getText() ;
            String actualNumber = AppHelper.driver.findElement(By.id("note_card_number")).getText() ;
            String actualStartDate = AppHelper.driver.findElement(By.id("note_card_valid_from")).getText() ;
            String actualEndDate = AppHelper.driver.findElement(By.id("note_card_valid_upto")).getText() ;
            String actualCvv = AppHelper.driver.findElement(By.id("note_card_cvv")).getText() ;
            assertThat(actualTitle, is("test")) ;
            assertThat(actualName, is("my card")) ;
            assertThat(actualNumber, is("1234-1234-1234-1234")) ;
            assertThat(actualStartDate, is("1111")) ;
            assertThat(actualEndDate, is("1120")) ;
            assertThat(actualCvv, is("222")) ;

            AppHelper.driver.findElementById("home").click();
        });

        Then("^the login note will not be changed$", () -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            assertThat(AppHelper.driver.findElement(By.id("note_login_url")).getText(), is("google.com"));
            assertThat(AppHelper.driver.findElement(By.id("note_login_name")).getText(), is("hello123"));
            assertThat(AppHelper.driver.findElement(By.id("note_login_password")).getText(), is("123***555"));

            AppHelper.driver.findElementById("home").click();
        });

    }
}
