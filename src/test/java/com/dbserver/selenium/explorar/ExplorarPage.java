package com.dbserver.selenium.explorar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dbserver.selenium.actions.ExplorarActions;
import com.dbserver.selenium.paginaBase.BasePage;

public class ExplorarPage extends BasePage<ExplorarActions>{
    
    public ExplorarPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement obterLinkExplorar(){
        return this.obterElementoPorDataTestId("nav-explorar");
    }
    public WebElement obterLinkNovoUsuario(){
        return this.obterElementoPorDataTestId("nav-novo-usuario");
    }
    public WebElement obterLinkMinhasPautas(){
        return this.obterElementoPorDataTestId("nav-minhas-pautas");
    }
    public WebElement obterLinkSair(){
        return this.obterElementoPorDataTestId("nav-logout");
    }

    public WebElement obterUltimaPautaCriada(){
        return this.obterElementoPorId("1");
    }

    public WebElement obterBotaoVotoPositivoUltimaPauta() {
        return this.obterElementoPorDataTestId("botao-voto-positivo-1");
    }
}
