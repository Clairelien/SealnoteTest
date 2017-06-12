import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import support.AppHelper;

/**
 * Created by Claire on 2017/6/12.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/createNewLoginNote.feature",
        glue = {"steps"},
        format = {"json:target/CreateNewLoginNote.json", "html:target/site/createLogin/cucumber-pretty"}
)
public class CreateNewLoginNoteTest extends AppHelper {
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
