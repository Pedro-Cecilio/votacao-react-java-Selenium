package com.dbserver.selenium.explorar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dbserver.selenium.actions.ExplorarActions;
import com.dbserver.selenium.paginaBase.BasePage;
import com.dbserver.selenium.utils.Utils;

public class ExplorarPage extends BasePage<ExplorarActions>{
    
    public ExplorarPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement obterLinkExplorar(){
        return this.navegador.findElement(Utils.byDataTestId("nav-explorar"));
    }
    public WebElement obterLinkNovoUsuario(){
        return this.navegador.findElement(Utils.byDataTestId("nav-novo-usuario"));
    }
    public WebElement obterLinkMinhasPautas(){
        return this.navegador.findElement(Utils.byDataTestId("nav-minhas-pautas"));
    }
    public WebElement obterLinkSair(){
        return this.navegador.findElement(Utils.byDataTestId("nav-logout"));
    }
}
