package com.example.sadidasiddiqui.stateslistproject;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private MyRecyclerViewAdapter adapter;
    private ArrayList<String> State_List;
    private  RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


        String[] StateList={"Alabama","Alaska", "Arizona", "Arkansas", "California","Colorado","Connecticut"
                ,"Delaware"
                ,"Florida"
                ,"Georgia"
                ,"Hawaii"
                ,"Idaho"
                ,"Illinois","Indiana"
                ,"Iowa"
                ,"Kansas"
                ,"Kentucky"
                ,"Louisiana"
                ,"Maine"
                ,"Maryland"
                ,"Massachusetts"
                ,"Michigan"
                ,"Minnesota"
                ,"Mississippi"
                ,"Missouri"
                ,"Montana","Nebraska"
                ,"Nevada"
                ,"New Hampshire"
                ,"New Jersey"
                ,"New Mexico"
                ,"New York"
                ,"North Carolina"
                ,"North Dakota"
                ,"Ohio"
                ,"Oklahoma"
                ,"Oregon"
                ,"Pennsylvania Rhode Island"
                ,"South Carolina"
                ,"South Dakota"
                ,"Tennessee"
                ,"Texas"
                ,"Utah"
                ,"Vermont"
                ,"Virginia"
                ,"Washington"
                ,"West Virginia"
                ,"Wisconsin"
                ,"Wyoming"};

        State_List = new ArrayList<String>(Arrays.asList(StateList));


        recyclerView = (RecyclerView)findViewById(R.id.my_recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(State_List);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


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
}
