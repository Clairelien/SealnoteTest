package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.openqa.selenium.By;
import support.AppHelper;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Claire on 2017/6/7.
 */
public class CreateNewCardNoteStepdefs implements En {
    public CreateNewCardNoteStepdefs() {
        Given("^user want to new a card note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView//android.widget.LinearLayout[@index='1']//android.widget.TextView")).click();
        });
        And("^user is editing a new card which the title is \"([^\"]*)\", the name is \"([^\"]*)\", the card number \"([^\"]*)\", valid from \"([^\"]*)\" to \"([^\"]*)\" and cvv is \"([^\"]*)\"$", (String title, String name, String number, String startDate, String endDate, String cvv) -> {
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys(title);
            AppHelper.driver.findElement(By.id("note_card_name")).sendKeys(name);
            AppHelper.driver.findElement(By.id("note_card_number")).sendKeys(number);
            AppHelper.driver.findElement(By.id("note_card_valid_from")).sendKeys(startDate);
            AppHelper.driver.findElement(By.id("note_card_valid_upto")).sendKeys(endDate);
            AppHelper.driver.findElement(By.id("note_card_cvv")).sendKeys(cvv);
        });
        When("^user submit the card note$", () -> {
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });
        Then("^there is a new note which the title is \"([^\"]*)\", the name is \"([^\"]*)\", the card number \"([^\"]*)\", valid from \"([^\"]*)\" to \"([^\"]*)\" and cvv is \"([^\"]*)\" in the sealnote$", (String title, String name, String number, String startDate, String endDate, String cvv) -> {
            AppHelper.driver.findElement(By.id("card_main_layout")).click();
//            String actualTitle = AppHelper.driver.findElement(By.id("note_activity_title")).getText() ;
            String actualName = AppHelper.driver.findElement(By.id("note_card_name")).getText() ;
            String actualNumber = AppHelper.driver.findElement(By.id("note_card_number")).getText() ;
            String actualStartDate = AppHelper.driver.findElement(By.id("note_card_valid_from")).getText() ;
            String actualEndDate = AppHelper.driver.findElement(By.id("note_card_valid_upto")).getText() ;
            String actualCvv = AppHelper.driver.findElement(By.id("note_card_cvv")).getText() ;
//            assertThat(actualTitle, is(title)) ;
            assertThat(actualName, is(name)) ;
//            assertThat(actualNumber, is(number)) ;
//            assertThat(actualStartDate, is(startDate)) ;
//            assertThat(actualEndDate, is(endDate)) ;
//            assertThat(actualCvv, is(cvv)) ;
        });
    }
}
