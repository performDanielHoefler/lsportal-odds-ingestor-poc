package com.statsperform.lsportal.oddsingestor.ingame;

import java.nio.charset.Charset;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class OddsListenerIngame implements MessageListener
{
	@Override
	public void onMessage(Message message)
	{
		String messageString = new String(message.getBody(), Charset.forName("UTF-8"));
		log.info("Ingame odds received: {} ", messageString);
	}
}