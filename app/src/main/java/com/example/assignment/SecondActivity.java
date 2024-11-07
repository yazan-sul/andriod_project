package com.example.assignment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    EditText height;
    EditText weight;
    EditText age;
    RadioButton gender;
    Button calculateBMR;
    TextView calculationResult;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        height = findViewById(R.id.heightEditText);
        weight = findViewById(R.id.weightEditText);
        age = findViewById(R.id.ageEditText);
        close = findViewById(R.id.close);
        calculateBMR = findViewById(R.id.calculateBMR);
        calculationResult = findViewById(R.id.calculationResult);
        RadioGroup radioGroupGender = findViewById(R.id.radioGroup);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        calculateBMR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = radioGroupGender.getCheckedRadioButtonId();
                if(selected != -1){
                    gender = findViewById(selected);
                    String selectedGender = gender.getText().toString();

                    // Show a Toast with the selected gender
                    Toast.makeText(SecondActivity.this, "Selected gender: " + selectedGender, Toast.LENGTH_SHORT).show();
                    Profile obj = new Profile(weight.getText().toString(),height.getText().toString(),age.getText().toString(), gender.getText().toString());
                    double result = calculateBMRBasedOnGender(obj);
                    calculationResult.setText("Your body needs to: "+result +" calories/day");
                }
                else {
                    // If no RadioButton is selected
                    Toast.makeText(SecondActivity.this, "No gender selected", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private double calculateBMRBasedOnGender(Profile obj){
        int heightI = obj.getHeight();
        int weightI = obj.getWeight();
        int ageI = obj.getAge();

        if(obj.getGender().equals("M"))
            return ((10*weightI) + (6.25*heightI) - (5*ageI) + 5);
        else
            return ((10*weightI) + (6.25*heightI) - (5*ageI) -161);
    }
}