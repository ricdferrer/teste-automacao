package br.ce.cucumberferrer.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features/inserir_conta.feature",
        glue = "br.ce.cucumberferrer.steps",
        plugin = {"pretty", "summary", "json:target/selenium-test.json"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class WebRunnerTest {

}
