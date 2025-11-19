package dev.itltcanz.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class NotificationProducerApplication {

  public static void main(String[] args) {
    SpringApplication.run(NotificationProducerApplication.class, args);
  }

}
