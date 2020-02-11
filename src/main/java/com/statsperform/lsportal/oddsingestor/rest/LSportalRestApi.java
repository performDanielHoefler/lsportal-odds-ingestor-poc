package com.statsperform.lsportal.oddsingestor.rest;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.statsperform.lsportal.oddsingestor.config.RestConfig;
import com.statsperform.lsportal.oddsingestor.rest.data.InplayScheduleData;

import lombok.extern.slf4j.Slf4j;

@Component
@Service
@EnableScheduling
@Slf4j
public class LSportalRestApi
{
	private RestConfig restConfig;
	private RestTemplate restTemplate;
	
	public LSportalRestApi(@Autowired RestTemplateBuilder builder,
			@Autowired RestConfig restConfig)
	{
		restTemplate = builder.build();
		this.restConfig = restConfig;
	}
	
	@Async
	@Scheduled(fixedRateString = "${lsportal.oddsingestor.rest.scheduleInterval:7200000}", initialDelay = 15000)
	public void getSchedule ()
	{
		try
		{
			URI url = buildScheduleUri ();
			InplayScheduleData data = restTemplate.getForObject(url, InplayScheduleData.class);
			log.info("Object {}", data);
		}
		catch (Exception e)
		{
			log.error("Error", e);
		}
	}

	private URI buildScheduleUri() throws URISyntaxException
	{
		String url = restConfig.getScheduleUrl();
		
		url = url.replace("%username%", restConfig.getUserName())
				.replace("%password%", restConfig.getPassword())
				.replace("%packageId%", String.valueOf(restConfig.getPackageId()));
		
		log.info("Schedule URL to get LSportal events: {}", url);
		
		return new URI(url);
	}
}