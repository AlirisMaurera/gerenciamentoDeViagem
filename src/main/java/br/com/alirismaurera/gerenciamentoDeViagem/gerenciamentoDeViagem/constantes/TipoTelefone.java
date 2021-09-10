package br.com.alirismaurera.gerenciamentoDeViagem.gerenciamentoDeViagem.constantes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {

    HOME ("home"),
    MOBILE("Mobile");

    private final String descricao;
}
