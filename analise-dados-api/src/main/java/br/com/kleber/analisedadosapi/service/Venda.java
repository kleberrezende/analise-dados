package br.com.kleber.analisedadosapi.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = {"vendaId"})
@Getter
public class Venda {

    private final String codigo;

    private final String vendaId;

    private final List<VendaItem> items;

    private final String vendedor;

    Venda() {
        codigo = "";
        vendaId = "";
        vendedor = "";
        items = new ArrayList();
    }

    Venda(List<String> dados) {
        codigo = dados.get(0);
        vendaId = dados.get(1);
        vendedor = dados.get(3);
        items = new ArrayList();
        Arrays.asList(dados.get(2).replace("[", "").replace("]", "").split(",")).forEach(item -> {
            items.add(new VendaItem(item));
        });
    }

    public BigDecimal getTotal() {
        return items.stream().map(item -> item.getTotal()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
