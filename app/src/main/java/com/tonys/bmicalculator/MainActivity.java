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

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private RadioButton radioMale;
    private RadioButton radioFemale;
    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;
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
        radioMale = findViewById(R.id.radio_button_male); // find the views on the UI
        radioFemale = findViewById(R.id.radio_button_female);
        ageEditText = findViewById(R.id.text_view_age);
        feetEditText = findViewById(R.id.text_view_feet);
        inchesEditText = findViewById(R.id.text_view_inches);
        weightEditText = findViewById(R.id.text_view_weight);
        calculateButton = findViewById(R.id.button_calculate);
        resultText = findViewById(R.id.text_view_result);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(new View.OnClickListener() { //listens for button clicks
            @Override
            public void onClick(View view) {
                calculateBMI(); //on click - run this method
            }
        });
    }

    private void calculateBMI() {
        String ageText = ageEditText.getText().toString();
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        //Convert number 'Strings' into 'int' variables
        int age = Integer.parseInt(ageText);
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;

        //Height in meters is inches multiplied by 0.0254
        double heightInMeters = totalInches * 0.0254;

        //BMI = weight * height squared
        double bmi = weight / (heightInMeters * heightInMeters);

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if (bmi < 18.5){
            // Display underweight
            fullResultString = bmiTextResult + "  - You are underweight";
        } else if (bmi > 25) {
            fullResultString = bmiTextResult + " - You are overweight";
        } else {
            fullResultString = bmiTextResult + " - You are a healthy weight";
        }
        resultText.setText(fullResultString);


    }





}