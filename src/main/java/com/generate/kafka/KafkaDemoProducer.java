package com.generate.kafka;



import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;


public class KafkaDemoProducer
{
	public void pushtokafka(String feed,String topicName)
	{
	       
	    Properties props = new Properties();
	    
	    props.put("bootstrap.servers", "clouderavm01.centralindia.cloudapp.azure.com:9092,clouderavm02.centralindia.cloudapp.azure.com:9092,clouderavm03.centralindia.cloudapp.azure.com:9092");
	          
	    props.put("acks", "all");
	    
	    props.put("retries", 0);
	    
	    //props.put("group.id", "testgroup");
	    
	    props.put("batch.size", 16384);
	       
	    props.put("linger.ms", 1);
	       
	    props.put("buffer.memory", 33554432);
	    
	    props.put("key.serializer", 
	       "org.apache.kafka.common.serialization.StringSerializer");
	       
	    props.put("value.serializer", 
	       "org.apache.kafka.common.serialization.StringSerializer");
	    
	    Producer<String, String> producer = new KafkaProducer
	       <String, String>(props);
	          
	    
	       producer.send(new ProducerRecord<String, String>(topicName, 
	           feed));
	             System.out.println("Message sent successfully "+feed);
	             producer.close();
	}

}
