package br.com.kleber.analisedadosapi.service;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = {"cnpj"})
@Getter
public class Cliente {

    private final String codigo;

    private final String cnpj;

    private final String nome;

    private final String area;

    Cliente(List<String> dados) {
        codigo = dados.get(0);
        cnpj = dados.get(1);
        nome = dados.get(2);
        area = dados.get(3);
    }

}
