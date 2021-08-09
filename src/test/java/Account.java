import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Account {

    private WebDriver driver;

    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
    }
    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Given("^the user navigate to register page")
    public void givenStatement() {
        driver.get("https://www.github.com");
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