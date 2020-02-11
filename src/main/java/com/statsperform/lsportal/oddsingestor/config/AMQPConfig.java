package com.statsperform.lsportal.oddsingestor.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.statsperform.lsportal.oddsingestor.ingame.OddsListenerIngame;
import com.statsperform.lsportal.oddsingestor.pregame.OddsListenerPregame;

@Configuration
public class AMQPConfig
{
	@Autowired
	private LSportalOddsIngestorPregameConfig pregameConfig;
	
	@Autowired
	private LSportalOddsIngestorIngameConfig ingameConfig;

	@Bean
	@Qualifier ("pregame_messagelistener")
	public SimpleMessageListenerContainer messageListenerContainerPregame()
	{
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(rabbitConnectionFactoryPregame());
		container.setQueueNames(pregameConfig.getQueueName());
		container.setMessageListener(new OddsListenerPregame());
		return container;
	}

	@Bean
	@Qualifier ("pregame_confac")
	public ConnectionFactory rabbitConnectionFactoryPregame()
	{
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(pregameConfig.getHost());
		connectionFactory.setUsername(pregameConfig.getUserName());
		connectionFactory.setPassword(pregameConfig.getPassword());
		connectionFactory.setPort(pregameConfig.getPort());
		connectionFactory.setVirtualHost(pregameConfig.getVirtualHost());
		connectionFactory.setConnectionTimeout(pregameConfig.getConnectionTimeout());
		connectionFactory.setRequestedHeartBeat(pregameConfig.getHeartbeatInterval());
		return connectionFactory;
	}

	@Bean
	@Qualifier ("ingame_messagelistener")
	public SimpleMessageListenerContainer messageListenerContainerIngame()
	{
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(rabbitConnectionFactoryIngame());
		container.setQueueNames(ingameConfig.getQueueName());
		container.setMessageListener(new OddsListenerIngame());
		return container;
	}

	@Bean
	@Qualifier ("ingame_confac")
	public ConnectionFactory rabbitConnectionFactoryIngame()
	{
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(ingameConfig.getHost());
		connectionFactory.setUsername(ingameConfig.getUserName());
		connectionFactory.setPassword(ingameConfig.getPassword());
		connectionFactory.setPort(ingameConfig.getPort());
		connectionFactory.setVirtualHost(ingameConfig.getVirtualHost());
		connectionFactory.setConnectionTimeout(ingameConfig.getConnectionTimeout());
		connectionFactory.setRequestedHeartBeat(ingameConfig.getHeartbeatInterval());
		return connectionFactory;
	}
}