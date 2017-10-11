package com.test.rest.app.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
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
		
		List<DBObject> listaUsuarios = users.find().toArray();
		
		
		listaUsuarios.forEach(user->{
			Users u = new Users();
			u.setId(user.get("_id").toString());
			u.setUsername(user.get("username").toString());
			u.setEmail(user.get("email").toString());
			u.setPassword(user.get("password").toString());
			listUsers.add(u);
		});
		
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
