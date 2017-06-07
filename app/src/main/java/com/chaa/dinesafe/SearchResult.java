package com.chaa.dinesafe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Amy on 2017-06-06.
 */

public class SearchResult extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView name = (TextView) findViewById(R.id.name);
        TextView address = (TextView) findViewById(R.id.address);
        TextView rating = (TextView) findViewById(R.id.rating);
        TextView inspection = (TextView) findViewById(R.id.inspection);

        ArrayList<String> info = getIntent().getStringArrayListExtra("INFO");

        name.setText(info.get(4));
        address.setText(info.get(6));
        rating.setText(info.get(7));
        inspection.setText("Last Inspection Date: "+info.get(10)+"\nInfraction Description: "+info.get(9));

    }

}
