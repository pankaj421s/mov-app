package com.example.kafkaapp.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;
import javax.jms.ConnectionFactory;

import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.r2dbc.ConnectionFactoryBuilder;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafkaapp.services.KafkaSender;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;

@RestController
@RequestMapping(path = "/root")
public class KafkaWebController {
	public static Logger logger=LoggerFactory.getLogger(KafkaWebController.class);
	@Autowired
	public KafkaSender kafkaSender;
	@Autowired
	public KafkaTemplate kafkaTemplate; 
	@Autowired
	public RedisTemplate redisTemplate;
	@Autowired
	public RedisConnectionFactory redisConnectionFactory;
	public MongoClient mongoClient;
	@GetMapping("/hello")
	//sync 
	@PostConstruct
	public void init()
	{
		List<MongoCredential> credentials=new ArrayList<MongoCredential>();
		credentials.add(MongoCredential.createCredential("pankaj421s","admin", "redelert".toCharArray()));
		//mongoClient=MongoClient.cr
		mongoClient=new MongoClient(new MongoClientURI("mongodb://pankaj421s:redelert@cluster0-shard-00-00.w09iq.mongodb.net:27017,cluster0-shard-00-01.w09iq.mongodb.net:27017,cluster0-shard-00-02.w09iq.mongodb.net:27017/admin?ssl=true&replicaSet=atlas-fivshw-shard-0&authSource=admin&retryWrites=true&w=majority"));
		//MongoCredential credentials=new MongoCr
		System.out.println("In init"+mongoClient);
		
	}
	public String sayHello()
	{
		
		return "Hello";
	}
	@GetMapping("/send")
	public String producer(@RequestParam("message") String message) throws InterruptedException, ExecutionException
	{
		//Criter
		System.out.println("in send");
	//logger.debug(kafkaTemplate.);
	System.out.println(redisTemplate.getConnectionFactory().getConnection());
	redisTemplate.opsForValue().set("name","Pankaj123");
    System.out.println(redisTemplate.opsForValue().get("name"));
	//	kafkaSender.send(message);
		return "Message sent to the Kafka Topic java_in_use_topic Successfully";
		
	}
	@GetMapping("add")
	public String add()
	{
	MongoDatabase mongoDatabase=mongoClient.getDatabase("mydb");
	//System.out.println(mongoClient.getMongoClientOptions().builder().);
	if(mongoDatabase.getCollection("Hello")==null)
	{
		mongoDatabase.createCollection("Hello");
	}
	//mongoDatabase.g
	//mongoDatabase.getCollection("hello").f
		//mongoDatabase.getCollection("hello").insertOne(new Document("name","pankaj"));;
	List<Document> databases=mongoClient.listDatabases().into(new ArrayList<>());
	databases.forEach(db->System.out.println(db.toJson()));
		System.out.println("<=====>");

	return "add";	
	}
	
	

}
