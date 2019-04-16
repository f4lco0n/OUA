package com.example.lab4_lists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.championsList);
        listView.setOnItemClickListener(itemClickListener);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



            if(position == 0){
                Intent intent = new Intent(MainActivity.this,HeroesActivity.class);
                startActivity(intent);
            }
            if(position == 1){
                Intent intent = new Intent(MainActivity.this,VillainsActivity.class);
                startActivity(intent);
            }
            if(position == 2){
                Intent intent = new Intent(MainActivity.this,MercenariesActivity.class);
                startActivity(intent);
            }


        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.empty){
            Intent intent = new Intent(MainActivity.this,activity_app_info.class);
            MainActivity.this.startActivity(intent);
            return  true;
        }
        return super.onOptionsItemSelected(item);
    }


}
