package br.com.beanascigom.pocscheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PocScheduledApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocScheduledApplication.class, args);
    }

}
