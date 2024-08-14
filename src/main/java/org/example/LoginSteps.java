package org.example;

import net.serenitybdd.annotations.Step;


public class LoginSteps {
    private LoginPage loginPage;

    @Step
    public void isOnLoginPage(){
        loginPage.open();
        loginPage.toLogin();
    }
}
