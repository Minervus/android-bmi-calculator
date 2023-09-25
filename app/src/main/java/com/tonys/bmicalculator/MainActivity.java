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

    private RadioButton radioMale;
    private RadioButton radioFemale;
    private EditText viewById;
    private EditText ageText;
    private EditText feetText;
    private EditText inchesText;
    private EditText weightText;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();


        setupButtonClickListener();
    }

    private void findViews(){
        radioMale = findViewById(R.id.radio_button_male);
        radioFemale = findViewById(R.id.radio_button_female);
        viewById = findViewById(R.id.text_view_age);
        ageText = viewById;
        feetText = findViewById(R.id.text_view_feet);
        inchesText = findViewById(R.id.text_view_inches);
        weightText = findViewById(R.id.text_view_weight);
        calculateButton = findViewById(R.id.button_calculate);
        resultText = findViewById(R.id.text_view_result);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
    }





}