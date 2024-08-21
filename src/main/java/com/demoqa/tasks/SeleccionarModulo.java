package com.demoqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ScrollToTarget;
import net.serenitybdd.screenplay.targets.Target;
public class SeleccionarModulo implements Task{

    private Target btnModulo;

    public SeleccionarModulo (Target btnModulo) {
        this.btnModulo = btnModulo;
    }
    public static SeleccionarModulo seleccionar(Target target) {
        return Tasks.instrumented(SeleccionarModulo.class, target);
    }


    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new ScrollToTarget(btnModulo), Click.on(btnModulo));
    }
}
