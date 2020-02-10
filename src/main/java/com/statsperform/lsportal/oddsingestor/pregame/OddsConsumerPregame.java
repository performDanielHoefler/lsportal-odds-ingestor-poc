package com.statsperform.lsportal.oddsingestor.pregame;

import java.io.IOException;
import java.nio.charset.Charset;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OddsConsumerPregame implements Consumer
{
	@Override
	public void handleShutdownSignal(String consumerTag, ShutdownSignalException sig)
	{
		log.info("handleShutdownSignal: consumerTag={}", consumerTag);
	}

	@Override
	public void handleRecoverOk(String consumerTag)
	{
		log.info("handleRecoverOk: consumerTag={}", consumerTag);
	}

	@Override
	public void handleDelivery(String consumerTag,
            Envelope envelope,
            AMQP.BasicProperties properties,
            byte[] body) throws IOException
	{
		String deserializedMessage = new String(body, Charset.forName("UTF-8"));
		log.info("handleDelivery: consumerTag={}, envelope={}, deserializedMessage={}", consumerTag,
				envelope, deserializedMessage);
	}

	@Override
	public void handleConsumeOk(String consumerTag)
	{
		log.info("handleConsumeOk: consumerTag={}", consumerTag);
	}

	@Override
	public void handleCancelOk(String consumerTag)
	{
		log.info("handleCancelOk: consumerTag={}", consumerTag);
	}

	@Override
	public void handleCancel(String consumerTag) throws IOException
	{
		log.info("handleCancel: consumerTag={}", consumerTag);
	}
}