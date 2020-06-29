package br.ce.cucumberferrer.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InserirContasSteps {

    private final String DRIVER_PATH = "C:\\WebDrivers\\chromedriver_win32\\83\\chromedriver.exe";
    public WebDriver driver;

    @Given("que estou acessando a aplicação")
    public void queEstouAcessandoAplicacao() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com/login");
        Thread.sleep(1000);
    }

    @When("informo o usuário {string}")
    public void informoUsuario(String string) throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys(string);
        Thread.sleep(1000);
    }

    @When("a senha {string}")
    public void aSenha(String string) throws InterruptedException {
        driver.findElement(By.id("senha")).sendKeys(string);
        Thread.sleep(1000);
    }

    @When("seleciono entrar")
    public void selecionoEntrar() throws InterruptedException {
        driver.findElement(By.tagName("button")).click();
        Thread.sleep(1000);
    }

    @Then("visualizo a página inicial")
    public void visualizoAPaginaInicial() throws InterruptedException {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Bem vindo, wagner!", texto);
        Thread.sleep(1000);
    }

    @When("seleciono Contas")
    public void selecionoContas() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
        Thread.sleep(1000);
    }

    @When("seleciono Adicionar")
    public void selecionoAdicionar() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(),'Adicionar')]")).click();
        Thread.sleep(1000);
    }

    @When("informo a conta {string}")
    public void informoAConta(String string) throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='nome']")).sendKeys(string);
        Thread.sleep(1000);
    }

    @When("seleciono Salvar")
    public void selecionoSalvar() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        Thread.sleep(1000);
    }

    @Then("a conta é inserida com sucesso")
    public void aContaInseridaComSucesso() throws InterruptedException {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", texto);
        Thread.sleep(1000);
        driver.quit();
    }
}
