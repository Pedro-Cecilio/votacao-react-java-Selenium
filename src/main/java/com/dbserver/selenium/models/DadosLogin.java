package com.dbserver.selenium.models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DadosLogin {
    private String email;
    private String senha;
}
