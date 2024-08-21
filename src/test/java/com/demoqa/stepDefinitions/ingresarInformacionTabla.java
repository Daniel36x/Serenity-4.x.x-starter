package com.demoqa.stepDefinitions;

import com.demoqa.tasks.IngresarValoresWebTable;
import com.demoqa.tasks.SeleccionarCategoria;
import com.demoqa.tasks.SeleccionarModulo;
import com.demoqa.utils.BuilderCsvWebTable;
import com.demoqa.utils.CsvFile;
import com.demoqa.utils.CsvModel;
import com.demoqa.utils.builders.BuilderCsv;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Presence;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.demoqa.userInterfaces.PaginaCategoria.MODULO;
import static com.demoqa.userInterfaces.PaginaPrincipal.CATEGORIA;
import static com.demoqa.userInterfaces.PaginaWebTableIngresado.FILA_NUEVA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class ingresarInformacionTabla {

    private EnvironmentVariables environmentVariables;

    @Before
    public void setup(){
        setTheStage(new OnlineCast());
        WebDriverManager.chromedriver().setup();
    }

    @Given("El {string} ingresa a la pagina de inicio")
    public void el_usuario_ingresa_a_la_pagina_de_inicio(String usuario) {
        theActorCalled(usuario).wasAbleTo(Open.url("https://demoqa.com/"));

    }
    @When("El usuario se dirige a la pagina del formulario")
    public void el_usuario_se_dirige_a_la_pagina_del_formulario() throws InterruptedException {
        theActorInTheSpotlight().attemptsTo(SeleccionarCategoria.seleccionar(CATEGORIA.of("Elements")));
        theActorInTheSpotlight().attemptsTo(SeleccionarModulo.seleccionar(MODULO.of("Web Tables")));

    }
    @When("Digita la informacion del scenario {string} en la tabla")
    public void digita_la_informacion_del_scenario_scenario1_en_la_tabla(String scenario) {
        List<Map<String, String>> totalData = CsvFile.read(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("pathData"));
        Optional<Map<String, String>> dataFilter = CsvFile.filter(totalData, scenario);
        CsvModel dataBuilder = new BuilderCsv(dataFilter.get()).build();
        theActorInTheSpotlight().attemptsTo(IngresarValoresWebTable.ingresar(dataBuilder));

    }
    @Then("Se verifica que la informacion haya quedado registrada")
    public void se_verifica_que_la_informacion_haya_quedado_registrada() {

        theActorInTheSpotlight().attemptsTo(Check.whether(Presence.of(FILA_NUEVA.of("Dennis"))));

    }
}
