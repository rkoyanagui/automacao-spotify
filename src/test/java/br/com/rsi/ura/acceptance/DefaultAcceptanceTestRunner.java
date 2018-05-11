package br.com.rsi.ura.acceptance;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import io.openbdt.cucumber.CucumberWithOpenBdt;

@RunWith(CucumberWithOpenBdt.class)

@CucumberOptions(features = {"src/test/resources/bdd/features"}, glue = {"br.com.rsi.ura.steps.gherkin"})

public class DefaultAcceptanceTestRunner {
}
