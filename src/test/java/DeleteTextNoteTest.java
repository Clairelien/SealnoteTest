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
        features = "src/test/features/deleteTextNote.feature",
        glue = {"steps"},
        format = {"json:target/DeleteTextNote.json", "html:target/site/deleteText/cucumber-pretty"}
)
public class DeleteTextNoteTest extends AppHelper {
    @BeforeClass
    public static void setUp() throws Exception {
        sealNoteSetupNoRest();
        loginToSealnote() ;
    }

    @AfterClass
    public static void tearDown() {
        closeSealnote();
    }
}
