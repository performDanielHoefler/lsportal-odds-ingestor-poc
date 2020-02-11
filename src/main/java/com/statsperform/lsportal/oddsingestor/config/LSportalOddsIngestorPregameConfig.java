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
	@Value ("${lsportal.oddsingestor.pregame.username}")
	private String userName;
	@Value ("${lsportal.oddsingestor.pregame.password}")
	private String password;
	@Value ("${lsportal.oddsingestor.pregame.virtualHost}")
	private String virtualHost;
	@Value ("${lsportal.oddsingestor.pregame.host}")
	private String host;
	@Value ("${lsportal.oddsingestor.pregame.port}")
	private int port;
	@Value ("${lsportal.oddsingestor.pregame.connectionTimeout}")
	private int connectionTimeout;
	@Value ("${lsportal.oddsingestor.pregame.heartbeatInterval}")
	private int heartbeatInterval;
	@Value ("${lsportal.oddsingestor.pregame.queueName}")
	private String queueName;
}
