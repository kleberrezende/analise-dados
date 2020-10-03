package br.com.kleber.analisedadosapi.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(of = {"itemId"})
@Getter
public class VendaItem {

    private final String itemId;

    private final BigDecimal quantidade;

    private final BigDecimal valor;

    VendaItem(String item) {
        List<String> dados = Arrays.asList(item.split("-"));
        itemId = dados.get(0);
        quantidade = new BigDecimal(dados.get(1));
        valor = new BigDecimal(dados.get(2));
    }

    public BigDecimal getTotal() {
        return valor.multiply(quantidade).setScale(2, RoundingMode.HALF_UP);
    }

}
