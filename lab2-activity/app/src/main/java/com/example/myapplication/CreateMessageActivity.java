package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;


public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
    }

    public void onSendMessage(View view) {
        EditText editText = (EditText) findViewById(R.id.message);
        String getMessage = editText.getText().toString();
        Intent intent = new Intent(this,ReceiveMessageActivity.class);
        intent.putExtra("MESSAGE",getMessage);
        startActivity(intent);
    }



    public void onThirdActivity(View view) {
        Intent intent = new Intent(this,ThirdActivity.class);
        startActivity(intent);
    }
}
