import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import support.AppHelper;

import java.util.concurrent.TimeUnit;

/**
 * Created by Claire on 2017/6/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/deleteTag.feature",
        glue = {"steps"},
        format = {"json:target/DeleteTag.json", "html:target/site/deleteTag/cucumber-pretty"}
)
public class DeleteTagTest extends AppHelper {

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
