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

import java.util.UUID;

public class Account {

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

    @Given("^the user navigate to register page")
    public void givenStatement() {

        driver.get("http://seubarriga.wcaquino.me/cadastro");
    }

    @When("^the user fill the fields")
    public void whenStatement(){
        fillRegisterForm(true);
    }

    @Then("^account should be create with success")
    public void thenStatement() throws Exception {
        WebElement msgSuccess = driver.findElement(By.xpath("/html/body/div[1]"));
        String result = msgSuccess.getText();

        ScreenShot.takeSnapShot(driver, System.getProperty("user.dir")
                + "/src/test/resources/screenShots/");

        Assert.assertEquals("Usuário inserido com sucesso", result);
    }

    @When("^the user fill the email field with a value already registered")
    public void whenStatementError(){
        fillRegisterForm(false);
    }

    @Then("^account should not be create and raise a message error")
    public void thenStatementError() throws Exception {
        WebElement msgSuccess = driver.findElement(By.xpath("/html/body/div[1]"));
        String result = msgSuccess.getText();

        ScreenShot.takeSnapShot(driver, System.getProperty("user.dir")
                + "/src/test/resources/screenShots/");

        Assert.assertEquals("Endereço de email já utilizado", result);
    }

    private void fillRegisterForm(boolean generateEmail) {
        String email = "Luiz@souza";

        if (generateEmail) {
            email = "Luiz@souza"+ UUID.randomUUID();
        }
        WebElement inputName = driver.findElement(By.id("nome"));
        inputName.sendKeys("Luiz");

        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys(email);

        WebElement inputSenha = driver.findElement(By.id("senha"));
        inputSenha.sendKeys("Felipe123");

        WebElement btnCadastrar = driver.findElement(By.xpath("/html/body/div[2]/form/input"));
        btnCadastrar.click();
    }
}