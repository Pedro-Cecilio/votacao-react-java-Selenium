package com.dbserver.selenium.fixture;

import com.dbserver.selenium.models.DadosNovaPauta;

public class NovaPautaFixture {
    public static final DadosNovaPauta criarNovaPautaCorretamente(){
        return DadosNovaPauta.builder()
               .assunto("Sabe programar em java?")
               .categoria("EDUCAÇÃO")
               .build();
    }
    public static final DadosNovaPauta criarNovaPautaAssuntoVazio(){
        return DadosNovaPauta.builder()
               .assunto("")
               .categoria("EDUCAÇÃO")
               .build();
    }
    public static final DadosNovaPauta criarNovaPautaCategoriaVazia(){
        return DadosNovaPauta.builder()
               .assunto("Sabe programar em java?")
               .categoria("")
               .build();
    }
}
