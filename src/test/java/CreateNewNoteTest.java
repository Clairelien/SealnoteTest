/**
 * Created by Claire on 2017/6/2.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/createNewNote.feature",
        glue = {"steps"},
        format = {"json:target/issuing_company_invoice_cucumber.json", "html:target/site/issuing/cucumber-pretty"}
)
public class CreateNewNoteTest {
    @BeforeClass
    public static void setUp() throws Exception {
        System.out.println("123");
        AppSetup.prepareSealNoteForAppium();
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("000");
        AppSetup.driver.quit();
    }
}
