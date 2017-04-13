package br.com.rafaelvcunha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"br.com.rafaelvcunha.server.model"})
@EnableJpaRepositories(basePackages = {"br.com.rafaelvcunha.server.repository"})
public class App 
{
    public static void main( String[] args ){
    	
    	SpringApplication.run(App.class, args);
    	
    }

    
}
