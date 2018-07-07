package com.example.sadidasiddiqui.menuproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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

        Button new_activity= (Button)findViewById(R.id.na);
        Button sms= (Button)findViewById(R.id.sms);
        Button phone= (Button)findViewById(R.id.phone);
        Button share= (Button)findViewById(R.id.share);
        Button web=(Button)findViewById(R.id.web);
        Button map=(Button)findViewById(R.id.map);


        new_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NewActivity.class));
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sms_intent=new Intent(Intent.ACTION_SENDTO);
                sms_intent.setData(Uri.parse("smsto:"+Uri.encode("17077167222")));
                sms_intent.putExtra("sms_body","Hi, I'm Sadida Siddiqui");
                startActivity(sms_intent);
            }

        });

        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent phone_intent = new Intent(Intent.ACTION_DIAL);
                phone_intent.setData(Uri.parse("tel:17077167222"));

                startActivity(phone_intent);
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share_intent = new Intent(Intent.ACTION_SEND);
                share_intent.setType("text/plain");
                share_intent.putExtra(Intent.EXTRA_SUBJECT,"CS639");
                share_intent.putExtra(Intent.EXTRA_TEXT,"Join CS639");

                startActivity(Intent.createChooser(share_intent, "Share the Love"));
                /*if (share_intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(chooser);
            }*/}
        });

        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent web_intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"));

                startActivity(web_intent);
            }

        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String geo_Uri=String.format("geo:23.032820,72.555011");
                Uri geo=Uri.parse(geo_Uri);
                Intent geo_intent=new Intent(Intent.ACTION_VIEW,geo);

                startActivity(geo_intent);

            }
        });




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
        }else if (id == R.id.action_help) {
            Intent intent = new Intent(this, HelpActivity.class);
            this.startActivity(intent);


            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
