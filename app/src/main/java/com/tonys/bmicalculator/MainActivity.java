package com.tonys.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

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

                double bmiResult = calculateBMI();


                String ageText = ageEditText.getText().toString();
                int age = Integer.parseInt(ageText);
                if(age > 18){
                    displayBMIResult(bmiResult);
                } else {
                    displayGuidance(bmiResult);
                }

            }
        });
    }



    private double calculateBMI() {

        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();

        //Convert number 'Strings' into 'int' variables

        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        int totalInches = (feet * 12) + inches;

        //Height in meters is inches multiplied by 0.0254
        double heightInMeters = totalInches * 0.0254;

        //BMI = weight * height squared
        return weight / (heightInMeters * heightInMeters);


    }

    private void displayBMIResult(double bmi) {
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

    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);
        String fullResultString;

        if(radioMale.isChecked()){
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for bmi for boys";
        } else if (radioFemale.isChecked()){
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for bmi for girls";
        } else {
            fullResultString = bmiTextResult + " - As you are under 18, please consult with your doctor for bmi";
        }
        resultText.setText(fullResultString);
    }





}