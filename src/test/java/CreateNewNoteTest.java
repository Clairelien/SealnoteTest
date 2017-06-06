/**
 * Created by Claire on 2017/6/2.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import support.AppHelper;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/createNewNote.feature",
        glue = {"steps"},
        format = {"json:target/issuing_company_invoice_cucumber.json", "html:target/site/issuing/cucumber-pretty"}
)
public class CreateNewNoteTest extends AppHelper {
    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("strat-------");
        sealNoteSetup();
        driver.findElement(By.id("password_meter_input")).sendKeys("123456");
        driver.findElement(By.id("password_action_button")).click();
    }

    @AfterClass
    public static void tearDown() {
        closeSealnote();
    }
}
