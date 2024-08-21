package com.demoqa.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "com.demoqa.stepDefinitions",
        features = "src/test/resources/com/demoqa/features/",
        publish = false
)
public class ingresarInformacionTablaRunner {
}
