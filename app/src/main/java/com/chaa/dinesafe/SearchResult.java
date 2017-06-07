package com.chaa.dinesafe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Initialization of Search Result
 */
public class SearchResult extends AppCompatActivity{


    /**
     * Sets content view to search result, changes text based on the specific restaurant info.
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView name = (TextView) findViewById(R.id.name);
        TextView address = (TextView) findViewById(R.id.address);
        TextView rating = (TextView) findViewById(R.id.rating);
        TextView inspection = (TextView) findViewById(R.id.inspection);

        String[] info = getIntent().getStringArrayExtra("INFO");

        name.setText(info[4]);
        address.setText(info[6]);
        rating.setText(info[7]);
        inspection.setText("Last Inspection Date: "+info[10]+"\nInfraction Description: "+info[9]);

    }

}
