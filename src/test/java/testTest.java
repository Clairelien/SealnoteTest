import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.AppHelper;

import java.util.concurrent.TimeUnit;

/**
 * Created by Claire on 2017/6/16.
 */
public class testTest extends AppHelper {

    @BeforeClass
    public static void setUp() throws Exception {
        sealNoteSetup();
        loginToSealnote() ;
        AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        AppHelper.driver.findElement(By.id("action_new_note")).click();
        AppHelper.driver.findElement(By.xpath("//android.widget.ListView[1]//android.widget.TextView")).click();

        AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AppHelper.driver.findElement(By.id("note_activity_title")).sendKeys("test");
        AppHelper.driver.findElement(By.id("note_activity_note")).sendKeys("hello");

        AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AppHelper.driver.findElement(By.id("action_save_note")).click();

        AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AppHelper.driver.findElementById("list_cardId").click();

        AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement titleEle = AppHelper.driver.findElementByXPath("//android.widget.EditText[@resource-id='note_activity_title']");//findElement(By.id("note_activity_title"));
        WebElement contentEle = AppHelper.driver.findElement(By.id("note_activity_note"));

        String actualTitle = titleEle.getAttribute("text");
        String actualContent = contentEle.getText();
    }

    @AfterClass
    public static void tearDown() {
        closeSealnote();
    }
}
