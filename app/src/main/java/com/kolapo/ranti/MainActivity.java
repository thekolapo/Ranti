package com.kolapo.ranti;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.MenuItemCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private RecyclerView mRecyclerView;
    private EventRecycleViewAdapter mAdapter;
    private ArrayList<EventModel>  mModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rvEvents);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemAnimator(new SlideInUpAnimator());

        //Set layout manager to position the items
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mModels = new ArrayList<>();
        mModels = getEvents();

        mAdapter = new EventRecycleViewAdapter(this, mModels);
        //Attach the adapter to the recyclerview to populate items
        mRecyclerView.setAdapter(mAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(this);
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

    @Override
    public boolean onQueryTextChange(String query) {
        final List<EventModel> filteredModelList = filter(mModels, query);
        mAdapter.animateTo(filteredModelList);
        mRecyclerView.scrollToPosition(0);
        return true;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    private List<EventModel> filter(List<EventModel> models, String query) {
        query = query.toLowerCase();

        final List<EventModel> filteredModelList = new ArrayList<>();
        for (EventModel model : models) {
            final String text = model.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    private ArrayList<EventModel> getEvents() {
        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.drawable.img_kp);
        Bitmap bm1 = BitmapFactory.decodeResource(getResources(),R.drawable.img_biodun);
        ArrayList<EventModel> items = new ArrayList<>();
        items.add(new EventModel("Biola's wedding anniversary", "March 30", bm));
        items.add(new EventModel("Kolapo's birthday", "May 30", bm));
        items.add(new EventModel("Fathers day message  to Biodun", "May 18", bm1));
        items.add(new EventModel("Christmas wishes to Christiana", "Dec 25", bm));
        items.add(new EventModel("Happy Easter message to Tola", "April 1", bm));

        items.add(new EventModel("Biola's wedding anniversary", "March 30", bm));
        items.add(new EventModel("Kolapo's birthday", "May 30", bm));
        items.add(new EventModel("Fathers day message  to Biodun", "May 18", bm1));
        items.add(new EventModel("Christmas wishes to Christiana", "Dec 25", bm));
        items.add(new EventModel("Happy Easter message to Tola", "April 1", bm));

        items.add(new EventModel("Biola's wedding anniversary", "March 30", bm));
        items.add(new EventModel("Kolapo's birthday", "May 30", bm));
        items.add(new EventModel("Christmas wishes to Christiana", "Dec 25", bm));
        items.add(new EventModel("Fathers day message  to Biodun", "May 18", bm1));
        items.add(new EventModel("Happy Easter message to Tola", "April 1", bm));

        items.add(new EventModel("Biola's wedding anniversary", "March 30", bm));
        items.add(new EventModel("Kolapo's birthday", "May 30", bm));
        items.add(new EventModel("Fathers day message  to Biodun", "May 18", bm1));
        items.add(new EventModel("Christmas wishes to Christiana", "Dec 25", bm));
        items.add(new EventModel("Happy Easter message to Tola", "April 1", bm));
        return items;
    }
}
