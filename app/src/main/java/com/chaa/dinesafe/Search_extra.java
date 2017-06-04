package com.chaa.dinesafe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.content.Intent;
import android.app.*;
import android.view.Menu;
import android.view.MenuInflater;
import android.content.Context;
import android.widget.SearchView;

public class Search_extra extends AppCompatActivity {
    EditText inputTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


        String query;

        inputTxt = (EditText) findViewById(R.id.search_input);
        query = inputTxt.getText().toString();

        Intent intent = getIntent();
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            doMySearch(query);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;
    }

    private void doMySearch(java.lang.String query){
        /*Cursor mCursor = this.getContentResolver().query(UserDictionary.Words.CONTENT_URI, null, null, null, null);
        startManagingCursor(mCursor);

        ListAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.two_line_list_item,
                mCursor,
                new String[] {UserDictionary.Words.WORD, UserDictionary.Words.FREQUENCY},
                new int[] {android.R.id.text1, android.R.id.text2});

        setListAdapter(adapter);*/
    }
}
