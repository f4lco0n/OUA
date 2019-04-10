package lab3.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onToggleClicked(View view) {

        textView = (TextView) findViewById(R.id.text1);
        boolean on = ((Switch) view).isChecked();
        if (on) {
            textView.setText("Włączony");
        } else {
            textView.setText("Wyłączony");
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkbox1:
                if (checked) {
                    CharSequence text = "Opcja pierwsza zaznaczona";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(this, text, duration);
                    toast.show();
                } else {
                    CharSequence text = "Opcja pierwsza odznaczona";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(this, text, duration);
                    toast.show();
                }
                break;
            case R.id.checkbox2:
                if (checked) {
                    CharSequence text = "Opcja druga zaznaczona";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(this, text, duration);
                    toast.show();
                } else {
                    CharSequence text = "Opcja druga odznaczona";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(this, text, duration);
                    toast.show();
                }
                break;
        }
    }

    public void onRadioButtonClicked(View view) {
        RadioGroup radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        int id = radioGroup.getCheckedRadioButtonId();
        switch(id) {
            case R.id.radio1:
                CharSequence text1 = "Pierwszy Radio zaznaczony";
                int duration1 = Toast.LENGTH_SHORT;
                Toast toast1 = Toast.makeText(this, text1, duration1);
                toast1.show();
                break;
            case R.id.radio2:
                CharSequence text2 = "Drugi Radio zaznaczony";
                int duration2 = Toast.LENGTH_SHORT;
                Toast toast2 = Toast.makeText(this, text2, duration2);
                toast2.show();
                break;
        }
    }

    public void onButtonCLicked(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }
}
