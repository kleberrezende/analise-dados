package br.com.kleber.analisedadosapi.component;

import br.com.kleber.analisedadosapi.service.AnalisarDadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ScheduledTaskComponent {

    @Autowired
    private AnalisarDadosService analisarDadosService;

    @Scheduled(cron = "*/30 * * * * *")
    public void analisarDados() {
        analisarDadosService.analisar();
    }

}
