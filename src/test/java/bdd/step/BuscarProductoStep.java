package bdd.step;

import bdd.page.BuscarProductoPage;

public class BuscarProductoStep {

    public BuscarProductoPage buscarProductoPage(){
        return new BuscarProductoPage();
    }

    public void stepIniciarNavegador(String url){
        buscarProductoPage().inicializarNavegador(url);
    }

    public void stepHacerClickenBuscar(){
        buscarProductoPage().hacerClickEnBuscador();
    }

    public void stepEscribirProducto(String txtProducto){
        buscarProductoPage().escribirProducto(txtProducto);
    }

    public void stepClickBuscarProducto(){
        buscarProductoPage().clickBuscarProducto();
    }

    public String stepValidarResultado(){
        return buscarProductoPage().validarResultado();
    }
}
