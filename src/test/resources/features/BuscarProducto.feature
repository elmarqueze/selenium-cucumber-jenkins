Feature: Buscar Producto

  @PRUEBA1
  Scenario: Buscar Producto de Sons of Anarchy
    Given ingreso a la pagina web de amazon "https://es.aliexpress.com/"
    When ingreso el texto "Merchandising Sons of Anarchy"
    And le doy click al botón buscar
    Then valido que me muestre el valor "Delivery options & services"
