package com.test.rest.app;

import static j2html.TagCreator.body;
import static j2html.TagCreator.h1;
import static j2html.TagCreator.head;
import static j2html.TagCreator.html;
import static spark.Spark.get;
import static spark.Spark.post;

import org.json.JSONObject;


/**
 * Hello world!
 *
 */
public class App {
	public static void main( String[] args )
    {


        get("/teste", (req, res)-> {
//        	res.type("application/json");
//        	System.out.println(req.params("name"));
        		return html().with(
        			head(),
        			body().with(
	        			h1("oi").attr("id", "teste"))
        			).render();
        	

        			
        	
        });
        JSONObject json = new JSONObject();
        json.put("username", "joao");
        post("/teste", (req, res)->{

        	res.type("application/json");
        	return json;
        });
    }	
}
