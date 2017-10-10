package com.test.rest.app;

import static spark.Spark.get;
import static spark.Spark.post;

import com.google.gson.Gson;
import com.test.rest.app.dao.UsersDAO;
import com.test.rest.app.models.Users;


/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args )
    {
		Gson gson = new Gson();
		UsersDAO usersDAO = new UsersDAO();
	
		
        get("/users", "application/json", (req, res)-> usersDAO.findAll(), gson::toJson);
        
       
        post("/users", "application/json", (req, res)->{
        	Users user = gson.fromJson(req.body(), Users.class);
        	usersDAO.add(user);
        	res.status(201);
        	return user;
        }, gson::toJson);
    }	
}
