package com.inoss.tuiapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.parse.ParseAnalytics;
import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;


public class ViewSpotFixListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_spot_fix_list);
        ParseAnalytics.trackAppOpened(getIntent());
        ListView listView = (ListView) findViewById(R.id.listView);
        ParseQueryAdapter<ParseObject> queryAdapter = new ParseQueryAdapter<ParseObject>(this,"TestObject");
        queryAdapter.setTextKey("foo");
        queryAdapter.setImageKey("Image");
        queryAdapter.setObjectsPerPage(10);
        listView.setAdapter(queryAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.create_spot_fix, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
