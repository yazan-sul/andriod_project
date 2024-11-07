package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ShowMealInfo extends AppCompatActivity {
    ImageView imageView;
    TextView title;
    TextView calories;
    Button close;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_meal_info);
        imageView = findViewById(R.id.image);
        title = findViewById(R.id.title);
        calories = findViewById(R.id.foodCalories);
        close = findViewById(R.id.close);
        Intent i = getIntent();
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();;
            }
        });
        int imageResId = i.getIntExtra("IMG_SRC", -1);
        if (imageResId != -1) {
            imageView.setImageResource(imageResId);
            title.setText(i.getStringExtra("TITLE_TEXT"));
            calories.setText(" "+i.getIntExtra("Calories_TEXT",-1) +" calories/day" );
        }else {
            // Handle the case where the image resource ID is not found (optional)
            Toast.makeText(this, "Image not found", Toast.LENGTH_SHORT).show();
        }

    }
}