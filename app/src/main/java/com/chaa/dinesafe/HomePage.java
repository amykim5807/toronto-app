package com.chaa.dinesafe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class HomePage extends AppCompatActivity {

    Button search;
    Button nearby;
    Button info;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_page);

        search = (Button) findViewById(R.id.search_button);

        search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent = new Intent(HomePage.this, Search.class);
                startActivity(myIntent);
            }
        });

        nearby = (Button) findViewById(R.id.nearby_button);

        nearby.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent myIntent2 = new Intent(HomePage.this, Nearby.class);
                startActivity(myIntent2);
            }
        });

        info = (Button) findViewById(R.id.info_button);

        info.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent3 = new Intent(HomePage.this,
                        Info.class);
                startActivity(myIntent3);
            }
        });
    }

}
