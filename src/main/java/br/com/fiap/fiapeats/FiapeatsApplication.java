package br.com.fiap.fiapeats;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class FiapeatsApplication {

  public static void main(String[] args) {
    System.out.println("*************************** Develop!!  ***************************");

    SpringApplication.run(FiapeatsApplication.class, args);
  }
}
