package com.example.lab4_lists;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class HeroesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes);
        ListView listView = (ListView) findViewById(R.id.heroList);
        listView.setOnItemClickListener(itemClickListener);
    }

    AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            if(position == 0){
                Intent intent = new Intent(HeroesActivity.this,HulkActivity.class);
                startActivity(intent);
            }
            if(position == 1){
                Intent intent = new Intent(HeroesActivity.this,CaptainAmericaActivity.class);
                startActivity(intent);
            }
            if(position == 2){
                Intent intent = new Intent(HeroesActivity.this,IronManActivity.class);
                startActivity(intent);
            }


        }
    };
}
