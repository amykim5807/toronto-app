package com.chaa.dinesafe;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Nearby extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);

        ArrayAdapter<String> adapter;
        ListView list = (ListView) findViewById(R.id.nearby_results);

        adapter=new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                searchNearby());
        list.setAdapter(adapter);
    }

    private ArrayList<String> searchNearby(){
        ArrayList<String> listItems=new ArrayList<String>();

        listItems.add("test_1");
        listItems.add("test_2");

        return listItems;
    }
}
