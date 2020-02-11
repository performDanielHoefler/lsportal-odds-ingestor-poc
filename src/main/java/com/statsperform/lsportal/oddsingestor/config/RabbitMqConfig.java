package com.statsperform.lsportal.oddsingestor.config;

import lombok.Getter;
import lombok.Setter;

public class RabbitMqConfig
{
	@Getter @Setter
	private String userName;

	@Getter @Setter
	private String password;

	@Getter @Setter
	private String virtualHost;

	@Getter @Setter
	private String host;

	@Getter @Setter
	private int port;

	@Getter @Setter
	private int connectionTimeout;

	@Getter @Setter
	private int heartbeatInterval;

	@Getter @Setter
	private String queueName;
}