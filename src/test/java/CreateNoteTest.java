/**
 * Created by Claire on 2017/6/2.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import support.AppHelper;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/createNote.feature",
        glue = {"steps"},
        format = {"json:target/CreateNote.json", "html:target/site/createNote/cucumber-pretty"}
)
public class CreateNoteTest extends AppHelper {
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
