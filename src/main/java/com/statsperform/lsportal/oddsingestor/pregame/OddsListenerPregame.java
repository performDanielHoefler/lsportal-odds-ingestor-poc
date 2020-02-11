package com.statsperform.lsportal.oddsingestor.pregame;

import java.nio.charset.Charset;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OddsListenerPregame
{
	@RabbitListener(queues = "${lsportal.oddsingestor.pregame.queueName}")
	public void listen(byte[] message)
	{
		String msg = new String(message, Charset.forName("UTF-8"));
		log.info("Received a new notification: {}", msg);
	}
}