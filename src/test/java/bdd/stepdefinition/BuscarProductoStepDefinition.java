package bdd.stepdefinition;

import bdd.step.BuscarProductoStep;
import bdd.webdriver.DOM;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.jupiter.api.Assertions;

public class BuscarProductoStepDefinition {

    private final BuscarProductoStep buscarProductoStep = new BuscarProductoStep();
    private final DOM dom  = new DOM();

    private Scenario scenario;

    @After
    public void afterScenario(){
        this.scenario = scenario;
        dom.takeScreenShot(scenario);
        dom.quitDriver();
    }

    @Given("ingreso a la pagina web de amazon {string}")
    public void ingresoALaPaginaWebDeAmazon(String url) {
        buscarProductoStep.stepIniciarNavegador(url);
    }

    @When("ingreso el texto {string}")
    public void ingresoElTexto(String txtProducto) {
        buscarProductoStep.stepHacerClickenBuscar();
        buscarProductoStep.stepEscribirProducto(txtProducto);
    }

    @And("le doy click al botón buscar")
    public void leDoyClickAlBotónBuscar() {
        buscarProductoStep.stepClickBuscarProducto();
    }

    @Then("valido que me muestre el valor {string}")
    public void validoQueMeMuestreElValor(String txtResultadoEsperado) {
        Assertions.assertEquals(txtResultadoEsperado, buscarProductoStep.stepValidarResultado());
    }
}
