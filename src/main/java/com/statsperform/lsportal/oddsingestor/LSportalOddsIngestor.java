package com.statsperform.lsportal.oddsingestor;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rball.rmq.connector.RmqConnector;
import com.statsperform.lsportal.oddsingestor.config.LSportalOddsIngestorIngameConfig;
import com.statsperform.lsportal.oddsingestor.config.LSportalOddsIngestorPregameConfig;
import com.statsperform.lsportal.oddsingestor.ingame.OddsConsumerIngame;
import com.statsperform.lsportal.oddsingestor.pregame.OddsConsumerPregame;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(exclude = { RestClientAutoConfiguration.class, SolrAutoConfiguration.class, DataSourceAutoConfiguration.class })
@Service
@Slf4j
public class LSportalOddsIngestor
{
	private LSportalOddsIngestorPregameConfig pregameConfig;
	private RmqConnector connectorPregameOdds;

	private LSportalOddsIngestorIngameConfig ingameConfig;
	private RmqConnector connectorIngameOdds;
	
	public LSportalOddsIngestor(@Autowired LSportalOddsIngestorPregameConfig configPregame,
			@Autowired LSportalOddsIngestorIngameConfig configIngame)
	{
		this.pregameConfig = configPregame;
		
		connectorPregameOdds = new RmqConnector(pregameConfig.getUserName(), pregameConfig.getPassword(),
				pregameConfig.getVirtualHost(), pregameConfig.getHost(),
				pregameConfig.getPort(), pregameConfig.getConnectionTimeout(), pregameConfig.getHeartbeatInterval());
		
		this.ingameConfig = configIngame;
		connectorIngameOdds = new RmqConnector(ingameConfig.getUserName(), ingameConfig.getPassword(),
				ingameConfig.getVirtualHost(), ingameConfig.getHost(),
				ingameConfig.getPort(), ingameConfig.getConnectionTimeout(), ingameConfig.getHeartbeatInterval());
	}
	
	@PostConstruct
	public void connectToRmqs () throws IOException, TimeoutException
	{
		startConsumingOdds (connectorPregameOdds, pregameConfig.getQueueName(), new OddsConsumerPregame());
		startConsumingOdds (connectorIngameOdds, ingameConfig.getQueueName(), new OddsConsumerIngame());
	}
	
	private void startConsumingOdds(RmqConnector connector, String queueName,
			Consumer consumer) throws IOException
	{
		Connection connectionPregameOdds = connector.createConnection();
		Channel channelPregameOdds = connector.createChannel(connectionPregameOdds);
		connector.consumeData(channelPregameOdds, queueName,true, consumer);
		
	}

	public static void main(String[] args)
	{
        SpringApplication.run(LSportalOddsIngestor.class, args);
    }
}