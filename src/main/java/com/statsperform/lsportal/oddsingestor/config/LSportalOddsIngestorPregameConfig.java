package com.statsperform.lsportal.oddsingestor.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Configuration
@EnableConfigurationProperties
public class LSportalOddsIngestorPregameConfig
{
	@Value ("${lsportal.oddsingestor.pregame.queueName}")
	private String queueName;
}