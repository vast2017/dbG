package com.vijay.db;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Mongo {

	public static void main(String[] args) {


		
		MongoClient mongoClient = new MongoClient();
		DB db = mongoClient.getDB("qa_auto");
//		boolean auth = db.authenticate("username", "password".toCharArray());
		
		DBCollection table = db.getCollection("employee");

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("age", 33);

		DBCursor cursor = table.find(searchQuery);

		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		
		
		
	}

}
