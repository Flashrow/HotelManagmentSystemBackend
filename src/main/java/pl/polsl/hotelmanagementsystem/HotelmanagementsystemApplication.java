package pl.polsl.hotelmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HotelmanagementsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelmanagementsystemApplication.class, args);
    }

}
