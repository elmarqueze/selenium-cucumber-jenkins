package bdd.page;

import bdd.webdriver.DOM;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BuscarProductoPage extends DOM {

    @FindBy(className = "search--keyword--15P08Ji")
    protected WebElement txtBuscar;

    @FindBy(className = "search--submit--2VTbd-T")
    WebElement btnBuscar;

    @FindBy(xpath = "//*[contains(text(),'Delivery options & services')]")
    WebElement resultadoObtenido;

    public void hacerClickEnBuscador(){
        onClick(txtBuscar);
    }

    public void inicializarNavegador(String url){
        iniciarNavegador(url);
    }

    public void escribirProducto(String txtProducto){
        type(txtBuscar, txtProducto);
    }

    public void clickBuscarProducto(){
        onClick(btnBuscar);
    }

    public String validarResultado(){
        return getText(resultadoObtenido);
    }
}
