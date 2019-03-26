package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
    }

    public void onSendMessage(View view) {
        Intent intent = new Intent(this,ReceiveMessageActivity.class);
        startActivity(intent);
    }

    public void onFirstActivity(View view) {
        Intent intent = new Intent(this,CreateMessageActivity.class);
        startActivity(intent);
    }
}
