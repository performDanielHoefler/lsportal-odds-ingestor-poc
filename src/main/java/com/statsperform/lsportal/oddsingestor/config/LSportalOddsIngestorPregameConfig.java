package com.statsperform.lsportal.oddsingestor.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Getter;

@Data
@Component
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties (prefix="lsportal.oddsingestor.pregame")
public class LSportalOddsIngestorPregameConfig
{
	@Getter
	private RabbitMqConfig rmqConfig;
}
