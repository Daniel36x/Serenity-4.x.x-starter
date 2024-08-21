package com.demoqa.userInterfaces;

import net.serenitybdd.screenplay.targets.Target;
public class PaginaWebTableIngresado {
    public static final Target FILA_NUEVA = Target.the("Fila nueva ingresada")
            .locatedBy("//*[text()='{0}']");
}
