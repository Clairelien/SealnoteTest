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
        features = "src/test/features/createTag.feature",
        glue = {"steps"},
        format = {"json:target/CreateTag.json", "html:target/site/createTag/cucumber-pretty"}
)
@Suite.SuiteClasses({CreateNoteTest.class, CreateTagTest.class})
public class CreateTagTest extends AppHelper {
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
