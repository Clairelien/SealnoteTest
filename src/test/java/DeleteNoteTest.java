import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import support.AppHelper;

import java.util.concurrent.TimeUnit;

/**
 * Created by Claire on 2017/6/12.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/deleteNote.feature",
        glue = {"steps"},
        format = {"json:target/DeleteNote.json", "html:target/site/deleteNote/cucumber-pretty"}
)
public class DeleteNoteTest extends AppHelper {

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
