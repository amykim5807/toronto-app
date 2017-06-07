package com.chaa.dinesafe;

/**
 * Created by Amy on 2017-06-04.
 */

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;
import java.util.ArrayList;
import java.util.List;

public class CityData {

    /*final String query = "Kenzo Ramen";

    MongoClientURI connectionString = new MongoClientURI("mongodb://hermishdm:m00nlanding@ds053176.mlab.com:53176");
    MongoClient mongoClient = new MongoClient(connectionString);

    DB database = mongoClient.getDB("new_dinesafe");

    DBCollection collection = database.getCollection("complaints");

    BasicDBObject queryDB = new BasicDBObject("establishment_name", query);
    DBCursor cursor = collection.find(queryDB);*/

}
