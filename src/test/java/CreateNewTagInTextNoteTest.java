import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import support.AppHelper;

/**
 * Created by Claire on 2017/6/12.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/createNewTagInTextNote.feature",
        glue = {"steps"},
        format = {"json:target/CreateNewTag.json", "html:target/site/createTag/cucumber-pretty"}
)
@Suite.SuiteClasses({CreateNewTextNoteTest.class, CreateNewTagInTextNoteTest.class})
public class CreateNewTagInTextNoteTest extends AppHelper {
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
