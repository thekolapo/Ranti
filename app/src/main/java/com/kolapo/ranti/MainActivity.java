package com.kolapo.ranti;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvEvents = (RecyclerView) findViewById(R.id.rvEvents);
        rvEvents.setHasFixedSize(true);

        //Set layout manager to position the items
        rvEvents.setLayoutManager(new LinearLayoutManager(this));

        EventRecycleViewAdapter adapter = new EventRecycleViewAdapter(this, getEvents());
        //Attach the adapter to the recyclerview to populate items
        rvEvents.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    private ArrayList<Event> getEvents() {
        ArrayList<Event> items = new ArrayList<Event>();
        items.add(new Event("Biola's wedding anniversary", "30 March"));
        items.add(new Event("Kolapo's birthday", "30 May"));
        items.add(new Event("Christmas wishes to Tinu", "25 Dec"));
        items.add(new Event("Easter message", "1 April"));
        return items;
    }
}
