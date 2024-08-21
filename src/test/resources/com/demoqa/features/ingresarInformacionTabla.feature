Feature: Ingresar informacion de archivo CSV a tabla de pagina web segun el scenario que seleccione

  Scenario Outline: Ingresar informacion segun el scenario que se seleccione
    Given El "usuario" ingresa a la pagina de inicio
    When El usuario se dirige a la pagina del formulario
    And Digita la informacion del scenario "<scenario>" en la tabla
    Then Se verifica que la informacion haya quedado registrada
    Examples:
      | scenario  |
      | Scenario1 |
      | Scenario2 |