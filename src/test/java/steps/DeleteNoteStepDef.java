package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import support.AppHelper;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Claire on 2017/6/12.
 */
public class DeleteNoteStepDef implements En {
    TouchAction action = new TouchAction(AppHelper.driver);
    public DeleteNoteStepDef() {

        Given("^user create two text note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();

            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys("test");
            AppHelper.driver.findElement(By.id("note_activity_note")).sendKeys("hello");
            AppHelper.driver.findElement(By.id("action_save_note")).click();

            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();

            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys("test2");
            AppHelper.driver.findElement(By.id("note_activity_note")).sendKeys("hello2");
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });
        When("^user delete these notes in the main page$", () -> {
            action.longPress( AppHelper.driver.findElementById("card_main_layout") ).release().perform() ;
            AppHelper.driver.findElement(By.xpath("//android.widget.AbsListView/android.widget.LinearLayout[@index='1']")).click();
            AppHelper.driver.findElementById("action_delete").click();
        });
        Then("^user can see these text notes in the trash section$", () -> {
            AppHelper.driver.findElement(By.id("android:id/action_bar_title")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='Trash']")).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            assertThat( AppHelper.driver.findElementByXPath("//android.widget.TextView[@text='test2']").getText(), is("test2") );
            assertThat( AppHelper.driver.findElementByXPath("//android.widget.TextView[@text='test']").getText(), is("test") );
            assertThat( AppHelper.driver.findElementByXPath("//android.widget.TextView[@text='hello']").getText(), is("hello") );
            assertThat( AppHelper.driver.findElementByXPath("//android.widget.TextView[@text='hello2']").getText(), is("hello2") );

            AppHelper.driver.findElement(By.id("home")).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='Notes']")).click();
        });
        Given("^user create text note$", () -> {
            AppHelper.driver.findElement(By.id("action_new_note")).click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();

            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys("test");
            AppHelper.driver.findElement(By.id("note_activity_note")).sendKeys("hello");
            AppHelper.driver.findElement(By.id("action_save_note")).click();
        });
        When("^user delete this note in the main page$", () -> {
            action.longPress( AppHelper.driver.findElementById("card_main_layout") ).release().perform() ;
            AppHelper.driver.findElementById("action_delete").click();
        });
        Then("^user can see the text note in the trash section$", () -> {
            AppHelper.driver.findElement(By.id("android:id/action_bar_title")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='Trash']")).click();
            AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            assertThat( AppHelper.driver.findElementById("card_header_inner_simple_title").getText(), is("test") );

            AppHelper.driver.findElement(By.id("home")).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AppHelper.driver.findElement(By.xpath("//android.widget.TextView[@text='Notes']")).click();
        });
        When("^user delete this note in the edit page$", () -> {
            AppHelper.driver.findElementById("card_main_layout").click();
            AppHelper.driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='More options']")).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            AppHelper.driver.findElementByXPath("//android.widget.TextView[@text='Delete']").click();
        });

    }
}
