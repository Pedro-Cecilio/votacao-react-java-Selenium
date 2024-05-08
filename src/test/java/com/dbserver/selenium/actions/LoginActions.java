package com.dbserver.selenium.actions;

import com.dbserver.selenium.fixture.LoginFixture;
import com.dbserver.selenium.login.LoginPage;
import com.dbserver.selenium.models.DadosLogin;
import com.dbserver.selenium.utils.Utils;

public class LoginActions extends LoginPage {

    public LoginActions navegarParaLogin() {
        this.navegador.navigate().to(URL_BASE);
        return this;
    }

    public ExplorarActions logarComoAdmin() {
        DadosLogin dados = LoginFixture.dadosLoginAdminValidos();
        return this.navegarParaLogin()
                .preencherFormularioDeLogin(dados)
                .enviarFormulario();
    }

    public ExplorarActions logarComoUsuario() {
        DadosLogin dados = LoginFixture.dadosLoginUsuarioValidos();
        return this.navegarParaLogin()
                .preencherFormularioDeLogin(dados)
                .enviarFormulario();
    }

    public LoginActions logarDadosIncorretos() {
        DadosLogin dados = LoginFixture.dadosLoginNaoCadastrado();
        this.navegarParaLogin()
                .preencherFormularioDeLogin(dados)
                .enviarFormulario();
        return this;
    }

    public LoginActions logarSenhaInvalida() {
        DadosLogin dados = LoginFixture.dadosLoginSenhaFormatoInvalido();
        this.navegarParaLogin()
                .preencherFormularioDeLogin(dados)
                .enviarFormulario();
        return this;
    }

    public LoginActions logarEmailInvalido() {
        DadosLogin dados = LoginFixture.dadosLoginEmailFormatoInvalido();
        this.navegarParaLogin()
                .preencherFormularioDeLogin(dados)
                .enviarFormulario();
        return this;
    }


    private LoginActions preencherFormularioDeLogin(DadosLogin dados) {
        this.obterInputEmail().sendKeys(dados.getEmail());
        this.obterInputSenha().sendKeys(dados.getSenha());
        return this;
    }

    private ExplorarActions enviarFormulario() {
        this.navegador.findElement(Utils.byDataTestId("botao-login")).click();
        return new ExplorarActions(navegador);
    }
}
