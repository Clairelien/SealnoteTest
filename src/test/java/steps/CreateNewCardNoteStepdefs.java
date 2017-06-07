package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;

/**
 * Created by Claire on 2017/6/7.
 */
public class CreateNewCardNoteStepdefs implements En {
    public CreateNewCardNoteStepdefs() {
        Given("^user want to new a card note$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        And("^user is editing a new card which the title is <title>, the name is <name>, valid from <startDate> to <endDate> and cvv is <cvv>$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        When("^user submit the card note$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
        Then("^there is a new note which the title is <title>, the name is <name>, valid from <startDate> to <endDate> and cvv is <cvv> in the sealnote$", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new PendingException();
        });
    }
}
