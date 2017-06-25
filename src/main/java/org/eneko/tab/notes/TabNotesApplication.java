package org.eneko.tab.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = "org.eneko.tab.notes")
@Configuration
public class TabNotesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TabNotesApplication.class, args);
    }


}
