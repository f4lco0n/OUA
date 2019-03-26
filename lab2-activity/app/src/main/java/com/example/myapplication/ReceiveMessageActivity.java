package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);
        TextView textView = (TextView) findViewById(R.id.textview1);
        Intent intent = getIntent();
        String getText = intent.getStringExtra("MESSAGE");
        textView.setText(getText);

    }

    public void onThirdActivity(View view) {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);

    }

    public void onFirstActivity(View view) {
        Intent intent = new Intent(this,CreateMessageActivity.class);
        startActivity(intent);

    }

}
