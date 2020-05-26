package xyz.chenww.newssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class NewSsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewSsmApplication.class, args);
    }

}
