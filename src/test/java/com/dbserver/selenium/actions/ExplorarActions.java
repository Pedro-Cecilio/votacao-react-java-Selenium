package com.dbserver.selenium.actions;

import org.openqa.selenium.WebDriver;

import com.dbserver.selenium.explorar.ExplorarPage;

public class ExplorarActions extends ExplorarPage{

    public ExplorarActions(WebDriver webDriver) {
        super(webDriver);
    }
    
    public CadastroUsuarioActions clicarEmNovoUsuario() {
        this.obterElementoPorDataTestId("nav-novo-usuario").click();
        return new CadastroUsuarioActions(this.navegador);
    }
}
