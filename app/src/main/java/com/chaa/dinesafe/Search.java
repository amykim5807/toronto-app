package com.chaa.dinesafe;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

/**
 * Initialization of Search Screen (main activity)
 */

public class Search extends AppCompatActivity {

    Button result;

    /**
     * Sets content view to search screen, with a dynamic ListView. The ListView items change color depending on the rating of the item,
     * and the ListView items are clickable (leading to the SearchResult class).
     * @param savedInstanceState
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ArrayAdapter<String> adapter;
        ListView list = (ListView) findViewById(R.id.search_results);
        //TextView searchTerm = (TextView) findViewById(R.id.search_term);

        final String query = "PIZZA";
        Log.d("test", query);
        ArrayList<String> listItems=new ArrayList<String>();
        listItems.add("pizza");

        /*String searchText = this.getResources().getString(R.string.search_query);
        searchTerm.setText(searchText+"\""+query+"\"");*/

        adapter=new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                listItems){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                String[] name = (String[]) ((this.getItem(position)).split("\n"));
                if (itemInfo(name[0])[7].equals("Pass")){
                    text.setTextColor(Color.GREEN);
                }
                else if (itemInfo(name[0])[7].equals("Conditional Pass")){
                    text.setTextColor(Color.YELLOW);
                }
                else if (itemInfo(name[0])[7].equals("Closed")){
                    text.setTextColor(Color.RED);
                }

                return view;
            }
        };
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long arg) {
                Intent appInfo = new Intent(Search.this, SearchResult.class);
                String[] name = (String[]) (((String)adapter.getItemAtPosition(position)).split("\n"));
                appInfo.putExtra("INFO", itemInfo(name[0]));
                startActivity(appInfo);
            }
        });
    }

    /**
     * This is a private search method that uses a local CSV file, reading each line to find a restaurant that contains the query in its name.
     * @param query - the search term that is used to query the database
     * @return ArrayList<String> - an Array List containing the name and address of all restaurants that match the query.
     */

    private ArrayList<String> searchQuery(String query){
        ArrayList<String> listItems=new ArrayList<String>();
        //listItems.add("Pizza Restaurant");
        String fileName = "dinesafeSmall.csv";

        try {
            InputStream is = getAssets().open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line = "";

            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");
                if (str[4].contains(query)){
                    listItems.add(str[4]+"\n"+str[6]);
                }
            }
        }
        catch(Exception e){
            Log.d("error",e.getMessage());
        }
        return listItems;
    }

    /**
     * This is a private search method that uses a local CSV file, reading each line to find the queried restaurant
     * @param query - should be the exact name of the restaurant
     * @return String[] - an array containing all the info of the queried restaurant
     */

    private String[] itemInfo(String query){
        String[] listItems=new String[14];
        String fileName = "dinesafeSmall.csv";

        try {
            InputStream is = getAssets().open(fileName);
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

            String line = "";

            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");
                if (str[4].equals(query)){
                    return str;
                }
            }
        }
        catch(Exception e){
            Log.d("error",e.getMessage());
        }
        return listItems;
    }

    /**
     * This is a private search method that queries the MongoDB.
     * @param query - the search term that is used to query the database
     * @return ArrayList<String> - an Array List containing the name and address of all restaurants that match the query.
     */

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
