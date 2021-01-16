package com.hackerrank.stocktrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.hackerrank.stocktrade.config.DbServerConfig;




@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.hackerrank.stoccktrade" })
@PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = false)
@Import({ DbServerConfig.class })
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    


}