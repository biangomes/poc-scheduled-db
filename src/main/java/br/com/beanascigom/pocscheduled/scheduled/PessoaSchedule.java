package br.com.beanascigom.pocscheduled.scheduled;

import br.com.beanascigom.pocscheduled.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class PessoaSchedule {
    @Autowired
    private PessoaService service;

    @Scheduled(cron = "*/30 * * * * ?")
    public void execFunc() {
        service.saveScheduling();
    }
}
