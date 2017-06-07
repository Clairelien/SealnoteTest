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
        features = "src/test/features/createNewTextNote.feature",
        glue = {"steps"},
        format = {"json:target/issuing_company_invoice_cucumber.json", "html:target/site/issuing/cucumber-pretty"}
)
public class CreateNewTestNoteTest extends AppHelper {
    @BeforeClass
    public static void setUp() throws Exception {
        sealNoteSetup();
        loginToSealnote() ;
    }

    @AfterClass
    public static void tearDown() {
        closeSealnote();
    }
}
