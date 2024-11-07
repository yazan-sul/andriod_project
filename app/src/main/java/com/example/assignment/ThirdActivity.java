package com.example.assignment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {
    private List<FoodType> meals;
    private ListView listView;
    Button close;
    private ArrayAdapter<String> foodAdapter;
    private List<Meals> mealsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        // Initialize subjects data
        initializeSubjects();

        // Set up the Spinner and ListView
        Spinner spinner = findViewById(R.id.spinnerFoodType);
        Button showBooksButton = findViewById(R.id.button);
        close= findViewById(R.id.close);
        listView = findViewById(R.id.linearLayout).findViewById(R.id.listView);

        // Get the subject names for the Spinner
        List<String> subjectNames = new ArrayList<>();
        for (FoodType subject : meals) {
            subjectNames.add(subject.getName());
        }
        mealsList = new ArrayList<>();
        for (FoodType foodType : meals) {
            mealsList.addAll(foodType.getList());
        }
        // Set up the ArrayAdapter for the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subjectNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // Set up button click listener
        showBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected subject
                String selectedSubject = spinner.getSelectedItem().toString();
                // Find the corresponding books
                List<Meals> food = getFoods(selectedSubject);
                // Display the books in the ListView
                List<String> info = new ArrayList<>();
                for (Meals meal : food) {
                    info.add(meal.getName());
                }
                // Update the ListView with book titles and prices
                foodAdapter = new ArrayAdapter<>(ThirdActivity.this, android.R.layout.simple_list_item_1, info);
                listView.setAdapter(foodAdapter);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getSelectedItem().toString().equals("Drinks")){
                    Intent ig = new Intent(ThirdActivity.this, ShowMealInfo.class);
                    ig.putExtra("TITLE_TEXT",mealsList.get(position+6).getName());
                    ig.putExtra("Calories_TEXT", mealsList.get(position+6).getCalories());
                    ig.putExtra("IMG_SRC", mealsList.get(position+6).getImageResId());
                    startActivity(ig);
                }
                else{
                    Toast.makeText(ThirdActivity.this, " " + mealsList.get(position).getName(), Toast.LENGTH_SHORT).show();
                    Intent ig = new Intent(ThirdActivity.this, ShowMealInfo.class);
                    ig.putExtra("TITLE_TEXT", mealsList.get(position).getName());
                    ig.putExtra("Calories_TEXT", mealsList.get(position).getCalories());
                    ig.putExtra("IMG_SRC", mealsList.get(position).getImageResId());
                    startActivity(ig);
                }
            }
        });
    }

    // Initialize the subjects and books
    private void initializeSubjects() {
        meals = new ArrayList<>();
        meals.add(new FoodType("Sandwiches", List.of(
                new Meals("Classic Turkey Sandwich", 350 ,R.drawable.classic_turkey),
                new Meals("Grilled Cheese Sandwich", 450,R.drawable.grilledcheese ),
                new Meals("BLT (Bacon, Lettuce, Tomato) Sandwich", 400,R.drawable.blt),
                new Meals("Chicken Caesar Sandwich", 500,R.drawable.chickencaesar),
                new Meals("Veggie and Hummus Sandwich", 360, R.drawable.veggiehummus),
                new Meals("Tuna Salad Sandwich", 420, R.drawable.tunasalad)
        )));
        meals.add(new FoodType("Drinks", List.of(
                new Meals("Coffee", 2,R.drawable.smallcupofcoffee),
                new Meals("Latte", 180,R.drawable.latte ),
                new Meals("Coca-Cola", 140, R.drawable.cocacola),
                new Meals("Orange Juice", 110, R.drawable.orangejuice)
                )));


    }
    private List<Meals> getFoods(String subjectName) {
        for (FoodType food : meals) {
            if (food.getName().equals(subjectName)) {
                return food.getList();
            }
        }
        return new ArrayList<>();
    }

}