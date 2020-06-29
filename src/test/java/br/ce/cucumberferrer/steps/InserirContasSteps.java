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
    public void queEstouAcessandoAplicacao() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        driver = new ChromeDriver();
        driver.get("https://srbarriga.herokuapp.com/login");
    }

    @When("informo o usuário {string}")
    public void informoUsuario(String string) {
        driver.findElement(By.id("email")).sendKeys(string);
    }

    @When("a senha {string}")
    public void aSenha(String string) {
        driver.findElement(By.id("senha")).sendKeys(string);
    }

    @When("seleciono entrar")
    public void selecionoEntrar() {
        driver.findElement(By.tagName("button")).click();
    }

    @Then("visualizo a página inicial")
    public void visualizoAPaginaInicial() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Bem vindo, wagner!", texto);
    }

    @When("seleciono Contas")
    public void selecionoContas() {
        driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
    }

    @When("seleciono Adicionar")
    public void selecionoAdicionar() {
        driver.findElement(By.xpath("//a[contains(text(),'Adicionar')]")).click();
    }

    @When("informo a conta {string}")
    public void informoAConta(String string) {
        driver.findElement(By.xpath("//input[@id='nome']")).sendKeys(string);
    }

    @When("seleciono Salvar")
    public void selecionoSalvar() {
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
    }

    @Then("a conta é inserida com sucesso")
    public void aContaInseridaComSucesso() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText();
        Assert.assertEquals("Conta adicionada com sucesso!", texto);
    }
}
