package com.demoqa.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaginaWebTables {

    public static final Target ADD = Target.the("Boton de agregar nueva fila").located(By.id("addNewRecordButton"));
    public static final Target FIRST_NAME = Target.the("Cuadro de  nombre").located(By.id("firstName"));
    public static final Target LAST_NAME = Target.the("Cuadro de apellido").located(By.id("lastName"));
    public static final Target EMAIL = Target.the("Cuadro de email").located(By.id("userEmail"));
    public static final Target AGE = Target.the("Cuadro de edad").located(By.id("age"));
    public static final Target SALARY = Target.the("Cuadro de salario").located(By.id("salary"));
    public static final Target DEPARTMENT = Target.the("Cuadro de departamento").located(By.id("department"));
    public static final Target SUBMIT = Target.the("Cuadro de departamento").located(By.id("submit"));
}
