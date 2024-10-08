package tn.esprit.spring.skistation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan (basePackages={"tn.esprit.spring.skistation.entity"})
@ComponentScan(basePackages = {"tn.esprit.spring.skistation.services","tn.esprit.spring.skistation.controllers"})
@EnableJpaRepositories(basePackages = {"tn.esprit.spring.skistation.repositories"})


public class SkistationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SkistationApplication.class, args);
    }

}
