package com.test.rest.app.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.test.rest.app.models.Users;
import com.test.rest.app.utils.ConnectionMongoDB;

public class UsersDAO implements Dao{

	
	private ConnectionMongoDB connection;
	
	public UsersDAO() {
		connection = new ConnectionMongoDB();
	}
	
	@Override
	public void add(Users users) throws UnknownHostException {
		DB db = connection.getConnection();
		DBCollection collection = db.getCollection("users");
		
		BasicDBObject basicDBObject = new BasicDBObject();
		basicDBObject.put("username", users.getUsername());
		basicDBObject.put("password", users.getPassword());
		basicDBObject.put("email", users.getEmail());
		collection.insert(basicDBObject);
		
	}

	@Override
	public List<Users> findAll() throws UnknownHostException {
		DB db = connection.getConnection();
		DBCollection users = db.getCollection("users");
		List<Users> listUsers = new ArrayList<>();
		
		DBCursor cursorUser = users.find();
		while(cursorUser.hasNext()){
			Users user = new Users();
			user.setId(cursorUser.next().get("_id").toString());
			user.setUsername(cursorUser.next().get("username").toString());
			user.setPassword(cursorUser.next().get("password").toString());
			user.setEmail(cursorUser.next().get("email").toString());
			listUsers.add(user);
		}
		
		return listUsers;
	}

	@Override
	public void delete(Users users) throws UnknownHostException {
		DB db = connection.getConnection();
		DBCollection collectionUsers = db.getCollection("users");
		BasicDBObject obj = new BasicDBObject();
		obj.put("_id", users.getId());
		collectionUsers.remove(obj);
	}

}
