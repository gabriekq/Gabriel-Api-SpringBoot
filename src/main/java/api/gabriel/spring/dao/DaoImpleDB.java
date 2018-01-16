package api.gabriel.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.mongodb.MongoClient;


@Component
public class DaoImpleDB {
	

private MongoTemplate templete;
//private MongoClient mongoClient;

@Autowired
public void setTemplete(MongoClient mongoClient ) {
	
templete = new MongoTemplate(mongoClient, "test");
   System.out.println("!!!valorDao-> "+mongoClient);
   System.out.println("!!!valorTT-> "+templete);
}


public MongoTemplate getTemplete() {
	return templete;
}







	
	
}
