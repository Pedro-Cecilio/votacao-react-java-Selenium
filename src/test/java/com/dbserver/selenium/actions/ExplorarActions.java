package com.dbserver.selenium.actions;

import org.openqa.selenium.WebDriver;

import com.dbserver.selenium.explorar.ExplorarPage;

public class ExplorarActions extends ExplorarPage{

    public ExplorarActions(WebDriver webDriver) {
        super(webDriver);
    }
    
    public CadastroUsuarioActions clicarEmNovoUsuario() {
        this.obterLinkNovoUsuario().click();
        return new CadastroUsuarioActions(this.navegador);
    }

    public MinhasPautasActions clicarEmMinhasPautas(){
        this.obterLinkMinhasPautas().click();
        return new MinhasPautasActions(this.navegador);
    }
}
