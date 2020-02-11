/*
package com.statsperform.lsportal.oddsingestor.ingame;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class OddsConsumerIngame
{
	@RabbitListener (queues="${lsportal.oddsingestor.ingame.queueName}")
	public void recievedMessages (String message)
	{
		log.info("Received ingame odds message via RMQ: {}", message);
	}
}
*/