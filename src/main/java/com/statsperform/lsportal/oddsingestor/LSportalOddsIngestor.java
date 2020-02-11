package com.statsperform.lsportal.oddsingestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.elasticsearch.rest.RestClientAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.solr.SolrAutoConfiguration;
import org.springframework.stereotype.Service;

@SpringBootApplication(exclude = { RestClientAutoConfiguration.class, SolrAutoConfiguration.class, DataSourceAutoConfiguration.class })
@Service
public class LSportalOddsIngestor
{
	public static void main(String[] args)
	{
        SpringApplication.run(LSportalOddsIngestor.class, args);
    }
}