package com.dbserver.selenium.actions;

import org.openqa.selenium.WebDriver;

import com.dbserver.selenium.cadastroUsuario.CadastroUsuarioPage;
import com.dbserver.selenium.fixture.CadastroUsuarioFixture;
import com.dbserver.selenium.models.DadosCadastroUsuario;

public class CadastroUsuarioActions extends CadastroUsuarioPage{

    public CadastroUsuarioActions(WebDriver navegador) {
        super(navegador);
    }
    
    private CadastroUsuarioActions preencherFormularioCadastro(DadosCadastroUsuario dados){
        this.obterInputEmail().sendKeys(dados.getEmail());
        this.obterInputSenha().sendKeys(dados.getSenha());
        this.obterInputNome().sendKeys(dados.getNome());
        this.obterInputSobrenome().sendKeys(dados.getSobrenome());
        this.obterInputCPF().sendKeys(dados.getCpf());
        this.obterInputTipoDeUsuario().sendKeys(dados.getTipoDeUsuario());
        return this;
    }

    private CadastroUsuarioActions clicarEmEnviar(){
        this.obterBotaoCadastrar().click();
        return this;
    }

    public CadastroUsuarioActions cadastrarUsuarioCorretamente(){
        DadosCadastroUsuario dados = CadastroUsuarioFixture.cadastroUsuarioValido();
        this.preencherFormularioCadastro(dados)
               .clicarEmEnviar();
        return this;
    }
    public CadastroUsuarioActions cadastrarUsuarioComEmailExistente(){
        DadosCadastroUsuario dados = CadastroUsuarioFixture.cadastroUsuarioEmailExistente();
        this.preencherFormularioCadastro(dados)
               .clicarEmEnviar();
        return this;
    }
    public CadastroUsuarioActions cadastrarUsuarioComCpfExistente(){
        DadosCadastroUsuario dados = CadastroUsuarioFixture.cadastroUsuarioCpfExistente();
        this.preencherFormularioCadastro(dados)
               .clicarEmEnviar();
        return this;
    }
}
