package com.fx.loja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.fx.loja.model")
@ComponentScan(basePackages={"com.*"})
@EnableJpaRepositories(basePackages={"com.fx.loja.repository"})
@EnableTransactionManagement
public class LojaVirtualApplication {

    public static void main(String[] args) {

        SpringApplication.run(LojaVirtualApplication.class, args);
    }

}
