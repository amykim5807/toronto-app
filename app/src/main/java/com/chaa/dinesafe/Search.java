package com.chaa.dinesafe;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class Search extends AppCompatActivity {

    Button result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        ArrayAdapter<String> adapter;
        ListView list = (ListView) findViewById(R.id.search_results);
        TextView searchTerm = (TextView) findViewById(R.id.search_term);

        Intent intent = getIntent();
        String searchInput = intent.getStringExtra("searchInput");

        String query = searchInput;
        query = "test_case";
        Log.d("test", query);

        String searchText = this.getResources().getString(R.string.search_query);
        searchTerm.setText(searchText+"\""+query+"\"");

        adapter=new ArrayAdapter<String>(getApplicationContext(),
                    android.R.layout.simple_list_item_1,
                    searchQuery(query));
        list.setAdapter(adapter);
    }

    private ArrayList<String> searchQuery(String query){
        ArrayList<String> listItems=new ArrayList<String>();

        listItems.add("test_1");
        listItems.add("test_2");

        return listItems;
    }
}
