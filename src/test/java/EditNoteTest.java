import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import support.AppHelper;

import java.util.concurrent.TimeUnit;

/**
 * Created by Claire on 2017/6/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/editNote.feature",
        glue = {"steps"},
        format = {"json:target/EditNote.json", "html:target/site/editNote/cucumber-pretty"}
)
public class EditNoteTest extends AppHelper {
    @BeforeClass
    public static void setUp() throws Exception {
        sealNoteSetup();
        loginToSealnote() ;
        AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        addBeforeDelete() ;
    }

    @AfterClass
    public static void tearDown() {
        closeSealnote();
    }
}
