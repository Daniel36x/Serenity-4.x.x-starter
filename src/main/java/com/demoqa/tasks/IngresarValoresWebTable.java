package com.demoqa.tasks;

import com.demoqa.userInterfaces.PaginaWebTables;
import com.demoqa.utils.BuilderCsvWebTable;
import com.demoqa.utils.CsvModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class IngresarValoresWebTable implements Task {

    CsvModel data;

    public IngresarValoresWebTable(CsvModel data) {
        this.data = data;
    }

    public static IngresarValoresWebTable ingresar(CsvModel data){
        return Tasks.instrumented(IngresarValoresWebTable.class, data);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(PaginaWebTables.ADD),
                Enter.theValue(data.getNombre()).into(PaginaWebTables.FIRST_NAME),
                Enter.theValue(data.getApellido()).into(PaginaWebTables.LAST_NAME),
                Enter.theValue(data.getEmail()).into(PaginaWebTables.EMAIL),
                Enter.theValue(data.getEdad()).into(PaginaWebTables.AGE),
                Enter.theValue(data.getSalario()).into(PaginaWebTables.SALARY),
                Enter.theValue(data.getDepartamento()).into(PaginaWebTables.DEPARTMENT),
                Click.on(PaginaWebTables.SUBMIT)
        );
    }
}
