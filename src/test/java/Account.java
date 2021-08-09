import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Account {
    @Given("^the user navigate to register page")
    public void givenStatement() {
        System.out.println("Given statement executed successfully");
    }

    @When("^the user fill the fields")
    public void whenStatement(){
        System.out.println("When statement executed successfully");
    }

    @Then("^account should be create with success")
    public void thenStatement(){
        System.out.println("Then statement executed successfully");
    }
}
