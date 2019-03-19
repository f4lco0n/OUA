package com.example.spinnerapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void add(View view){
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        TextView textView = (TextView) findViewById(R.id.result);

        int spinner1Value = Integer.parseInt(spinner1.getSelectedItem().toString());
        int spinner2Value = Integer.parseInt(spinner2.getSelectedItem().toString());

        textView.setText(String.valueOf(spinner1Value + spinner2Value));
    }

    public void subtract(View view){
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        TextView textView = (TextView) findViewById(R.id.result);

        int spinner1Value = Integer.parseInt(spinner1.getSelectedItem().toString());
        int spinner2Value = Integer.parseInt(spinner2.getSelectedItem().toString());

        textView.setText(String.valueOf(spinner1Value - spinner2Value));

    }


    public void multiply(View view) {
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        TextView textView = (TextView) findViewById(R.id.result);

        int spinner1Value = Integer.parseInt(spinner1.getSelectedItem().toString());
        int spinner2Value = Integer.parseInt(spinner2.getSelectedItem().toString());

        textView.setText(String.valueOf(spinner1Value * spinner2Value));
    }

    public void divide(View view) {
        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        TextView textView = (TextView) findViewById(R.id.result);
        float spinner1Value = Float.parseFloat(spinner1.getSelectedItem().toString());
        float spinner2Value = Float.parseFloat(spinner2.getSelectedItem().toString());
        if (spinner2Value == 0){
            textView.setText("Divisior is 0");
        } else {
            textView.setText(String.valueOf(spinner1Value / spinner2Value));
        }
    }
}
