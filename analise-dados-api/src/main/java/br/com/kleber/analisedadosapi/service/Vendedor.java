package br.com.kleber.analisedadosapi.service;

import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = {"nome"})
@Getter
public class Vendedor {

    private final String codigo;

    private final String cpf;

    private final String nome;

    private final String salario;

    Vendedor(List<String> dados) {
        codigo = dados.get(0);
        cpf = dados.get(1);
        nome = dados.get(2);
        salario = dados.get(3);
    }

}
