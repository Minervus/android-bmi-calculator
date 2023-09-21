package com.tonys.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioButton radioMale = findViewById(R.id.radio_button_male);
        RadioButton radioFemale = findViewById(R.id.radio_button_female);

        EditText ageText = findViewById(R.id.text_view_age);
        EditText feetText = findViewById(R.id.text_view_feet);
        EditText inchesText = findViewById(R.id.text_view_inches);
        EditText weightText = findViewById(R.id.text_view_weight);

        Button calculateButton = findViewById(R.id.button_calculate);
        TextView resultText = findViewById(R.id.text_view_result);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Autocomplete is OP", Toast.LENGTH_SHORT).show();
            }
        });

    }
}