package org.nil.learning.config;

import java.net.InetAddress;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "org.nil.learning.repository")
public class ESconfig {

	@Value("${elasticsearch.host}")
	private String EShost;

	@Value("${elasticsearch.port}")
	private int EsPort;

	@Value("${elasticsearch.clustername}")
	private String EsClusterName;

	@Bean
    public Client client() throws Exception {
    	Settings esSettings = Settings.builder()
                					  .put("cluster.name", EsClusterName)
                					  .build();
    	TransportClient client = new PreBuiltTransportClient(esSettings);
    	client.addTransportAddress(new TransportAddress(InetAddress.getByName(EShost),EsPort));
    	return client;
    }
	
	@Bean
	public ElasticsearchOperations elasticSearchTemplate() throws Exception {
		return new ElasticsearchTemplate(client());
	}
}
