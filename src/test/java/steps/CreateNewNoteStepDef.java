package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

/**
 * Created by Claire on 2017/6/2.
 */
public class CreateNewNoteStepDef implements En{
    public CreateNewNoteStepDef() {
        When("^user submit the note$", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("when");
            //throw new PendingException();
        });
        Given("^user is editing a new test note$", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("given");
            //throw new PendingException();
        });
        Then("^there is a new note in the sealnote$", () -> {
            // Write code here that turns the phrase above into concrete actions
            System.out.println("then");
            //throw new PendingException();
        });
    }
}
