package com.demoqa.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SeleccionarCategoria implements Task {

    private Target btnCategoria;

    public SeleccionarCategoria(Target btnCategoria) {
        this.btnCategoria = btnCategoria;
    }

    public static SeleccionarCategoria seleccionar(Target target){
        return Tasks.instrumented(SeleccionarCategoria.class, target);
    }

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(Click.on(btnCategoria));
    }
}
