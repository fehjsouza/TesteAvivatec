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

public class Crud {
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

    @Given("access the site with correct login")
    public void access_the_site_with_correct_login() {
        driver.get("http://seubarriga.wcaquino.me/login");

        Login login = new Login();
        login.accessAccount("Luiz@souza", "Felipe123", driver);
    }

    @When("accessing the accounts tab create an Account")
    public void accessing_the_accounts_tab_create_an_Account() {

        WebElement btnContas = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a"));
        btnContas.click();

        WebElement optAdicionar = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[1]/a"));
        optAdicionar.click();

        WebElement inputName = driver.findElement(By.id("nome"));
        inputName.sendKeys("Conta" + UUID.randomUUID());

        WebElement btnSalvar = driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/button"));
        btnSalvar.click();
    }

    @Then("save account and wait for the message {string}")
    public void save_account_and_wait_for_the_message(String message) throws Exception {
        WebElement msgSuccess = driver.findElement(By.xpath("/html/body/div[1]"));
        String result = msgSuccess.getText();

        ScreenShot.takeSnapShot(driver, System.getProperty("user.dir")
                + "/src/test/resources/screenShots/");

        Assert.assertEquals(message, result);
    }

    @When("access the accounts page and edit the first item")
    public void accessing_the_accounts_tab_edit_an_Account_created_previously() {

        driver.get("http://seubarriga.wcaquino.me/contas");

        WebElement btnEdit = driver.findElement(By.xpath("//*[@id=\"tabelaContas\"]/tbody/tr/td[2]/a[1]/span"));
        btnEdit.click();

        WebElement inputName = driver.findElement(By.id("nome"));
        inputName.sendKeys("Edited");

        WebElement btnSalvar = driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/button"));
        btnSalvar.click();
    }

    @When("access the accounts page and delete the first item")
    public void accessing_the_accounts_tab_delete_an_Account_called() {

        driver.get("http://seubarriga.wcaquino.me/contas");

        WebElement btnEdit = driver.findElement(By.xpath("/html/body/table/tbody/tr[1]/td[2]/a[2]/span"));
        btnEdit.click();
    }
}