
package com.hackerrank.stocktrade.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "com.hackerrank.stocktrade" })
@EntityScan(value = { "com.hackerrank.stocktrade.model" })
@EnableJpaRepositories(basePackages = { "com.hackerrank.stocktrade.dao" })
@EnableTransactionManagement
public class DbServerConfig {
}
