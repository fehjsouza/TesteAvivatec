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

public class Createeditdelete {
    WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
                + "/src/test/resources/chromedriver");

        System.setProperty("webdriver.chrome.whitelistedIps", "");

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

    }

    @When("accessing the accounts tab create an Account called {int}")
    public void accessing_the_accounts_tab_create_an_Account_called(Integer int1) {

        accessAccount("feh_jsouza@hotmail.com", "Felipe123");

        WebElement btnContas = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a"));
        btnContas.click();

        WebElement optAdicionar = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[1]/a"));
        optAdicionar.click();

        WebElement inputName = driver.findElement(By.id("nome"));
        inputName.sendKeys("Conta 1");

        WebElement btnSalvar = driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/button"));
        btnSalvar.click();

    }

    @Then("save account and wait for the message <message>")
    public void save_account_and_wait_for_the_message_message() {
        WebElement msgSuccess = driver.findElement(By.xpath("/html/body/div[1]"));
        String result = msgSuccess.getText();

        Assert.assertEquals("Conta adicionada com sucesso!", result);
    }

    @When("accessing the accounts tab edit an Account called {int}")
    public void accessing_the_accounts_tab_edit_an_Account_called(Integer int1) {

        WebElement btnEdit = driver.findElement(By.xpath("//*[@id=\"tabelaContas\"]/tbody/tr/td[2]/a[1]/span"));
        btnEdit.click();

        WebElement inputName = driver.findElement(By.id("nome"));
        inputName.sendKeys("Conta 2");

        WebElement btnSalvar = driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/button"));
        btnSalvar.click();

    }

    @When("accessing the accounts tab delete an Account called {int}")
    public void accessing_the_accounts_tab_delete_an_Account_called(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    public void accessAccount(String user,String password){
        WebElement inputEmail = driver.findElement(By.id("email"));
        inputEmail.sendKeys(user);

        WebElement inputSenha = driver.findElement(By.id("senha"));
        inputSenha.sendKeys(password);

        WebElement btnEntrar = driver.findElement(By.xpath("/html/body/div[2]/form/button"));
        btnEntrar.click();
    }
}
