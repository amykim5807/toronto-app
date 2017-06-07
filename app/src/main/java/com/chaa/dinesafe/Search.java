package com.chaa.dinesafe;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Search extends ListActivity {

    Button result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ArrayAdapter<String> adapter;
        ListView list = (ListView) findViewById(R.id.search_results);
        //TextView searchTerm = (TextView) findViewById(R.id.search_term);

        String query = "PIZZA";
        Log.d("test", query);
        ArrayList<String> listItems=new ArrayList<String>();
        listItems.add("pizza");

        /*String searchText = this.getResources().getString(R.string.search_query);
        searchTerm.setText(searchText+"\""+query+"\"");*/

        adapter=new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                listItems);
        list.setAdapter(adapter);
    }

    private ArrayList<String> searchQuery(String query){
        ArrayList<String> listItems=new ArrayList<String>();
        listItems.add("Pizza Restaurant");
        String fileName = "dinesafeSmall.csv";

        try {
            InputStream is = getAssets().open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            /*String line = "";

            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");
                if (str[4].contains(query)){
                    listItems.add(str[4]+"\n"+str[6]);
                }
            }*/
        }
        catch(Exception e){
            Log.d("error",e.getMessage());
        }
        return listItems;
    }

    /*
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        new AlertDialog.Builder(this)
                .setTitle("Hello")
                .setMessage("from " + getListView().getItemAtPosition(position))
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {}
                        })
                .show();

        Toast.makeText(Search.this,
                "ListView: " + l.toString() + "\n" +
                        "View: " + v.toString() + "\n" +
                        "position: " + String.valueOf(position) + "\n" +
                        "id: " + String.valueOf(id),
                Toast.LENGTH_LONG).show();
    }*/


    /*
    private ArrayList<String> mongoSearchQuery(String query){
        ArrayList<String> listItems=new ArrayList<String>();

        listItems.add("test_1");
        listItems.add("test_2");

        MongoClientURI connectionString = new MongoClientURI("mongodb://hermishdm:m00nlanding@ds053176.mlab.com:53176");
        MongoClient mongoClient = new MongoClient(connectionString);

        DB database = mongoClient.getDB("new_dinesafe");

        DBCollection collection = database.getCollection("complaints");

        BasicDBObject queryDB = new BasicDBObject("establishment_name", query);
        DBCursor cursor = collection.find(queryDB);

        try{
            while(cursor.hasNext()){
                Log.d("test",cursor.next().toString());
            }
        } finally{
            cursor.close();
        }

        return listItems;
    }*/


}
