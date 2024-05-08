package com.dbserver.selenium.models;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DadosNovaPauta {
    private String assunto;
    private String categoria;
}
