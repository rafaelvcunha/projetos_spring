  package com.devmedia.server.run;
   
  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.boot.orm.jpa.EntityScan;
  import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
   
  @SpringBootApplication
  @EntityScan(basePackages = {
              "com.devmedia.server.model"
              })
  @EnableJpaRepositories(basePackages = {
              "com.devmedia.server.repository"
              })
  public class Application {
   
      public static void main(String[] args) {
          SpringApplication.run(Application.class, args);    
      }
      
  }