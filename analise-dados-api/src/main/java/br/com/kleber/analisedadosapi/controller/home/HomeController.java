package br.com.kleber.analisedadosapi.controller.home;

import br.com.kleber.analisedadosapi.viewmodel.mensagem.MensagemVM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "/home")
    public ResponseEntity home() {
        System.out.println("Projeto Análise de dados working.");
        return ResponseEntity.ok(new MensagemVM("Projeto Análise de dados working."));
    }

}
