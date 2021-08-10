import helpers.ScreenShot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "/src/test/resources/chromedriver");

        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @When("the user logs in, will have a problem with user login")
    public void the_user_logs_in_will_have_a_problem_with_user_login() {

        accessAccount("Luiz@souza","Felipe1990", driver);
    }

    @Then("the password address incorrect")
    public void the_password_address_incorrect() throws Exception {
        WebElement msgSuccess = driver.findElement(By.xpath("/html/body/div[1]"));
        String result = msgSuccess.getText();

        ScreenShot.takeSnapShot(driver, System.getProperty("user.dir")
                + "/src/test/resources/screenShots/");

        Assert.assertEquals("Problemas com o login do usuário", result);
    }

    @Given("access navigate to home page")
    public void access_navigate_to_home_page() {
        driver.get("http://seubarriga.wcaquino.me/login");
    }

    @When("the user logs in, will give a welcome message")
    public void the_user_logs_in_will_give_a_welcome_message() {

        accessAccount("Luiz@souza","Felipe123", driver);
    }

    @Then("the account must be logged in correctly with no errors")
    public void the_account_must_be_logged_in_correctly_with_no_errors() throws Exception {
        WebElement msgSuccess = driver.findElement(By.xpath("/html/body/div[1]"));
        String result = msgSuccess.getText();

        ScreenShot.takeSnapShot(driver, System.getProperty("user.dir")
                + "/src/test/resources/screenShots/");

        Assert.assertEquals("Bem vindo, Luiz!", result);
    }

    public void accessAccount(String user,String password, WebDriver driver){
        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys(user);

        WebElement inputSenha = driver.findElement(By.id("senha"));
        inputSenha.sendKeys(password);

        WebElement btnEntrar = driver.findElement(By.xpath("/html/body/div[2]/form/button"));
        btnEntrar.click();
    }
}