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
public class LSportalOddsIngestorIngameConfig
{
	@Value ("${lsportal.oddsingestor.ingame.username}")
	private String userName;
	@Value ("${lsportal.oddsingestor.ingame.password}")
	private String password;
	@Value ("${lsportal.oddsingestor.ingame.virtualHost}")
	private String virtualHost;
	@Value ("${lsportal.oddsingestor.ingame.host}")
	private String host;
	@Value ("${lsportal.oddsingestor.ingame.port}")
	private int port;
	@Value ("${lsportal.oddsingestor.ingame.connectionTimeout}")
	private int connectionTimeout;
	@Value ("${lsportal.oddsingestor.ingame.heartbeatInterval}")
	private int heartbeatInterval;
	@Value ("${lsportal.oddsingestor.ingame.queueName}")
	private String queueName;
}
