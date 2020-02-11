package com.statsperform.lsportal.oddsingestor.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;
import lombok.Getter;

@Data
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties (prefix="lsportal.oddsingestor.rest")
public class RestConfig
{
	@Getter
	private int packageId;

	@Getter
	private String userName;

	@Getter
	private String password;

	@Getter
	private int scheduleInterval;
	
	@Getter
	private String scheduleUrl;
}