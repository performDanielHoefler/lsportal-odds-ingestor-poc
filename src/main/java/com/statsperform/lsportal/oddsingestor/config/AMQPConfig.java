package com.statsperform.lsportal.oddsingestor.config;

import org.springframework.amqp.core.MessageListener;
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
/*
	@Bean
	@Qualifier ("pregame_messagelistener")
	public SimpleMessageListenerContainer messageListenerContainerPregame()
	{
		return createSimpleMessageListenerContainer (pregameConfig.getRmqConfig(), new OddsListenerPregame(), rabbitConnectionFactoryPregame());
	}

	@Bean
	@Qualifier ("pregame_confac")
	public ConnectionFactory rabbitConnectionFactoryPregame()
	{
		return createConnectionFactory (pregameConfig.getRmqConfig());
	}

	@Bean
	@Qualifier ("ingame_messagelistener")
	public SimpleMessageListenerContainer messageListenerContainerIngame()
	{
		return createSimpleMessageListenerContainer (ingameConfig.getRmqConfig(), new OddsListenerIngame(), rabbitConnectionFactoryIngame());
	}

	@Bean
	@Qualifier ("ingame_confac")
	public ConnectionFactory rabbitConnectionFactoryIngame()
	{
		return createConnectionFactory(ingameConfig.getRmqConfig());
	}
*/
	private SimpleMessageListenerContainer createSimpleMessageListenerContainer(RabbitMqConfig config,
			MessageListener listener, ConnectionFactory connectionFactory)
	{
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(config.getQueueName());
		container.setMessageListener(listener);
		return container;
	}

	private ConnectionFactory createConnectionFactory(RabbitMqConfig rmqConfig)
	{
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory(rmqConfig.getHost());
		connectionFactory.setUsername(rmqConfig.getUserName());
		connectionFactory.setPassword(rmqConfig.getPassword());
		connectionFactory.setPort(rmqConfig.getPort());
		connectionFactory.setVirtualHost(rmqConfig.getVirtualHost());
		connectionFactory.setConnectionTimeout(rmqConfig.getConnectionTimeout());
		connectionFactory.setRequestedHeartBeat(rmqConfig.getHeartbeatInterval());
		return connectionFactory;
	}
}