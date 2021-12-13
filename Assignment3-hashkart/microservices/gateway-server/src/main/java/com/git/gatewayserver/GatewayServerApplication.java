package com.git.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;



@EnableZuulProxy
@EnableDiscoveryClient
@EnableAsync
@SpringBootApplication
@ComponentScan(basePackages={"com.git"})
@EnableJpaRepositories("com.git.dataaccesslayer.repository")
@EntityScan("com.git.dataaccesslayer.entity")
public class GatewayServerApplication {

	@Bean
	public PreFilter perFilter() {
		return new PreFilter();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(GatewayServerApplication.class, args);
	}

}
