import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import support.AppHelper;

import java.util.concurrent.TimeUnit;

/**
 * Created by Claire on 2017/6/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/editTag.feature",
        glue = {"steps"},
        format = {"json:target/EditTag.json", "html:target/site/editTag/cucumber-pretty"}
)
public class EditTagTest extends AppHelper{
    @BeforeClass
    public static void setUp() throws Exception {
        sealNoteSetup();
        loginToSealnote() ;
        AppHelper.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        addBeforeDelete() ;
    }

//    @Before
//    public void beforeEveryTestCase() {
//        AppHelper.driver.findElementById("home").click();
//    }

    @AfterClass
    public static void tearDown() {
        closeSealnote();
    }
}
