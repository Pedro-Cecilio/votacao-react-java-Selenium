package com.dbserver.selenium.cadastroUsuario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.dbserver.selenium.actions.CadastroUsuarioActions;
import com.dbserver.selenium.paginaBase.BasePage;
import com.dbserver.selenium.utils.Utils;

public class CadastroUsuarioPage extends BasePage<CadastroUsuarioActions> {
    
    public CadastroUsuarioPage(WebDriver navegador) {
        super(navegador);
    }
    public WebElement obterInputEmail(){
        return this.navegador.findElement(Utils.byDataTestId("input-email"));
    }
    public WebElement obterInputSenha() {
        return this.navegador.findElement(Utils.byDataTestId("input-senha"));
    }

    public WebElement obterInputNome() {
        return this.navegador.findElement(Utils.byDataTestId("input-nome"));
    }

    public WebElement obterInputSobrenome() {
        return this.navegador.findElement(Utils.byDataTestId("input-sobrenome"));
    }

    public WebElement obterInputCPF() {
        return this.navegador.findElement(Utils.byDataTestId("input-cpf"));
    }

    public WebElement obterInputTipoDeUsuario() {
        return this.navegador.findElement(Utils.byDataTestId("input-tipoDeUsuario"));
    }

    public WebElement obterBotaoCadastrar() {
        return this.navegador.findElement(Utils.byDataTestId("botao-criarUsuario"));
    }
    
}
