package com.statsperform.lsportal.oddsingestor.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.statsperform.lsportal.oddsingestor.pregame.OddsListenerPregame;

@Configuration
public class AMQPConfigPregameOdds
{
	@Autowired
	private LSportalOddsIngestorPregameConfig pregameConfig;

	@Bean
	Queue queue()
	{
		return new Queue(pregameConfig.getQueueName(), true);
	}

	@Bean
	MessageListenerAdapter listenerAdapter(OddsListenerPregame listener)
	{
		MessageListenerAdapter listenerAdapter = new MessageListenerAdapter(listener, "listen");
		return listenerAdapter;
	}
}