package br.com.kleber.analisedadosapi.controller.analisardados;

import br.com.kleber.analisedadosapi.service.AnalisarDadosService;
import br.com.kleber.analisedadosapi.viewmodel.mensagem.MensagemVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalisarDadosController {

    @Autowired
    private AnalisarDadosService analisarDadosService;

    @RequestMapping(method = RequestMethod.GET, value = "/analisarDados")
    public ResponseEntity analisarDados() {
        analisarDadosService.analisar();
        return ResponseEntity.ok(new MensagemVM("Dados analisados com sucesso."));
    }

}
