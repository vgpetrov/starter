package com.vp.starter;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * - Prometheus & grafana
 *   https://dzone.com/articles/monitoring-using-spring-boot-2-prometheus-and-graf
 *   https://habr.com/ru/post/548700/
 *
 */
@SpringBootApplication
@EntityScan(basePackages = "com.vp.starter.entities")
public class StarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarterApplication.class, args);
	}

	@Bean
	MeterRegistryCustomizer<MeterRegistry> metricsCommonTags() {
		return registry -> registry.config().commonTags("application", "java-starter-app");
	}

}
