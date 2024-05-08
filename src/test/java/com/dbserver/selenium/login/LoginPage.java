package com.dbserver.selenium.login;

import org.openqa.selenium.WebElement;

import com.dbserver.selenium.actions.LoginActions;
import com.dbserver.selenium.paginaBase.BasePage;
import com.dbserver.selenium.utils.Utils;

public class LoginPage extends BasePage<LoginActions> {

    public WebElement obterInputEmail(){
        return this.navegador.findElement(Utils.byDataTestId("input-email"));
    }
    public WebElement obterInputSenha(){
        return this.navegador.findElement(Utils.byDataTestId("input-senha"));
    }
    public WebElement obterBotaoEnviar(){
        return  this.navegador.findElement(Utils.byDataTestId("botao-login"));
    }
}
