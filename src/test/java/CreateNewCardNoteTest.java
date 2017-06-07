/**
 * Created by Claire on 2017/6/7.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import support.AppHelper;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/createNewCardNote.feature",
        glue = {"steps"},
        format = {"json:target/CreateNewCardNote.json", "html:target/site/createCard/cucumber-pretty"}
)
public class CreateNewCardNoteTest {
}
