package com.test.rest.app.utils;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class ConnectionMongoDB {
	
	public DB getConnection() throws UnknownHostException{
		MongoClient mongo = new MongoClient("localhost", 27017);
		return mongo.getDB("mydb");
	}
	
	
//	public static void main(String[] args) throws UnknownHostException {
//		ConnectionMongoDB connection = new ConnectionMongoDB();
//		DB db = connection.getConnection();
//		
//		DBCollection users = db.getCollection("users");
//		DBCursor todosUsers = users.find();
//		while(todosUsers.hasNext()){
//			System.out.println(todosUsers.next());
//		}
//	}
}
