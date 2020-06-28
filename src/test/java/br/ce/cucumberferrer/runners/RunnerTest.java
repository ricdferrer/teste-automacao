package br.ce.cucumberferrer.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "./src/test/resources/features/alugar_filme.feature",
        glue = "br.ce.cucumberferrer.steps",
        plugin = {"pretty", "html:target/report-cucumber.html"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class RunnerTest {

}
