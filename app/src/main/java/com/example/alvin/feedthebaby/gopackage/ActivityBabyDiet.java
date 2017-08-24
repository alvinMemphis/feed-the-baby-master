package com.example.alvin.feedthebaby.gopackage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.alvin.feedthebaby.BAdapter;
import com.example.alvin.feedthebaby.Baby;
import com.example.alvin.feedthebaby.Diet;
import com.example.alvin.feedthebaby.R;
import com.example.alvin.feedthebaby.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;


public class ActivityBabyDiet extends AppCompatActivity {


    List<Diet> dietArrayList = new ArrayList<>();
    BAdapter mAdapter;
    private RecyclerView recyclerView;
    SQLiteHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_diet);




        DB = new SQLiteHelper(ActivityBabyDiet.this);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mAdapter = new BAdapter(dietArrayList);
        RecyclerView.LayoutManager llm = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareMovieData();
    }

    private void prepareMovieData(){

        List<Baby> c = DB.getAllRecords();
        ArrayList<String> r = new ArrayList<String>();
        for (Baby num : c){
            r.add(num.getAge());
        }
        if(r.get(r.size()-1).equals("4") || Integer.parseInt(r.get(r.size()-1)) < 4){
            dietArrayList.add(new Diet("AGE -- Birth to 4 months","WHAT TO FEED -- Breast milk or formula ONLY",
                    "Your baby digestive tract is still developing,so no solid food for now"));

            dietArrayList.add(new Diet("AGE -- 4 to 6 months","WHAT TO FEED -- Breast milk," +
                    " smashed sweet potatoes, apples and banana juice, beans soup, meat and chicken soup",
                    "HOW TO FEED -- Begin with about 1 teaspon pured food or cereal(beans) then you can increase to 1 " +
                            "tablespoon when the baby has gotten used"));

            dietArrayList.add(new Diet("AGE -- 6 to 8 months","WHAT TO FEED -- Breast milk, strained vegetables(well cooked carrots)," +
                    " oats porridge, meat soup(from pork, chicken, beef), small amount of unsweetened yogurt",
                    "HOW TO FEED -- 1 teaspoon fruit juice, 1 teaspoon vegetables, 3 to 9 tablespoons cereal"));

            dietArrayList.add(new Diet("AGE -- 8 to 10 months","WHAT TO FEED -- Breast milk, Mashed vegetables(well cooked carrots)," +
                    "Mashed fruits(bananas,peaches,pears), iron-fortified cereal(beans,wheat), small bits of meat, boneless fish",
                    "HOW TO FEED -- 1/4 cup of milk, 1/2 cup of iron-fortified cereal, 3/4 cup of fruit juice"));

            dietArrayList.add(new Diet("AGE -- 10 to 12 months","WHAT TO FEED -- Breast milk or formula PLUS, soft cheese," +
                    " fruits cut into cubes, combo foods(macaroni), " +
                    "protein(small bits of meat,boneless fish)",
                    "HOW TO FEED -- 1/3 cup of milk, 3 to 4 tablespoons of protein food, 3/4 cup of vegetables, 3/4 cup of fruit juice"));

            dietArrayList.add(new Diet("AGE --12 months and above","WHAT TO FEED --formula PLUS, soft cheese," +
                    " fruits cut into cubes, combo foods(macaroni), " +
                    "protein(medium bits of meat,bonny fish)",
                    "HOW TO FEED -- 1 cup of milk, 3 to 4 tablespoons of protein food, 1 cup of vegetables, 1 cup of fruit juice"));
        }
        else if (Integer.parseInt(r.get(r.size()-1))>=5 && Integer.parseInt(r.get(r.size()-1))<8){
            dietArrayList.add(new Diet("AGE -- 4 to 6 months","WHAT TO FEED -- Breast milk," +
                    " smashed sweet potatoes, apples and banana juice, beans soup, meat and chicken soup",
                    "HOW TO FEED -- Begin with about 1 teaspon pured food or cereal(beans) then you can increase to 1 " +
                            "tablespoon when the baby has gotten used"));


            dietArrayList.add(new Diet("AGE -- 6 to 8 months","WHAT TO FEED -- Breast milk, strained vegetables(well cooked carrots)," +
                    " oats porridge, meat soup(from pork, chicken, beef), small amount of unsweetened yogurt",
                    "HOW TO FEED -- 1 teaspoon fruit juice, 1 teaspoon vegetables, 3 to 9 tablespoons cereal"));

            dietArrayList.add(new Diet("AGE -- 8 to 10 months","WHAT TO FEED -- Breast milk, Mashed vegetables(well cooked carrots)," +
                    "Mashed fruits(bananas,peaches,pears), iron-fortified cereal(beans,wheat), small bits of meat, boneless fish",
                    "HOW TO FEED -- 1/4 cup of milk, 1/2 cup of iron-fortified cereal, 3/4 cup of fruit juice"));

            dietArrayList.add(new Diet("AGE -- 10 to 12 months","WHAT TO FEED -- Breast milk or formula PLUS, soft cheese," +
                    " fruits cut into cubes, combo foods(macaroni), " +
                    "protein(small bits of meat,boneless fish)",
                    "HOW TO FEED -- 1/3 cup of milk, 3 to 4 tablespoons of protein food, 3/4 cup of vegetables, 3/4 cup of fruit juice"));
            dietArrayList.add(new Diet("AGE --12 months and above","WHAT TO FEED --formula PLUS, soft cheese," +
                    " fruits cut into cubes, combo foods(macaroni), " +
                    "protein(medium bits of meat,bonny fish)",
                    "HOW TO FEED -- 1 cup of milk, 3 to 4 tablespoons of protein food, 1 cup of vegetables, 1 cup of fruit juice"));
        }

        else if (Integer.parseInt(r.get(r.size()-1))>=8 && Integer.parseInt(r.get(r.size()-1))<10){
            dietArrayList.add(new Diet("AGE -- 8 to 10 months","WHAT TO FEED -- Breast milk, Mashed vegetables(well cooked carrots)," +
                    "Mashed fruits(bananas,peaches,pears), iron-fortified cereal(beans,wheat), small bits of meat, boneless fish",
                    "HOW TO FEED -- 1/4 cup of milk, 1/2 cup of iron-fortified cereal, 3/4 cup of fruit juice"));


            dietArrayList.add(new Diet("AGE -- 10 to 12 months","WHAT TO FEED -- Breast milk or formula PLUS, soft cheese," +
                    " fruits cut into cubes, combo foods(macaroni), " +
                    "protein(small bits of meat,boneless fish)",
                    "HOW TO FEED -- 1/3 cup of milk, 3 to 4 tablespoons of protein food, 3/4 cup of vegetables, 3/4 cup of fruit juice"));

            dietArrayList.add(new Diet("AGE --12 months and above","WHAT TO FEED --formula PLUS, soft cheese," +
                    " fruits cut into cubes, combo foods(macaroni), " +
                    "protein(medium bits of meat,bonny fish)",
                    "HOW TO FEED -- 1 cup of milk, 3 to 4 tablespoons of protein food, 1 cup of vegetables, 1 cup of fruit juice"));
        }

        else if (Integer.parseInt(r.get(r.size()-1))>=11 && Integer.parseInt(r.get(r.size()-1))<12){

            dietArrayList.add(new Diet("AGE -- 10 to 12 months","WHAT TO FEED -- Breast milk or formula PLUS, soft cheese," +
                    " fruits cut into cubes, combo foods(macaroni), " +
                    "protein(small bits of meat,boneless fish)",
                    "HOW TO FEED -- 1/3 cup of milk, 3 to 4 tablespoons of protein food, 3/4 cup of vegetables, 3/4 cup of fruit juice"));

            dietArrayList.add(new Diet("AGE --12 months and above","WHAT TO FEED --formula PLUS, soft cheese," +
                    " fruits cut into cubes, combo foods(macaroni), " +
                    "protein(medium bits of meat,bonny fish)",
                    "HOW TO FEED -- 1 cup of milk, 3 to 4 tablespoons of protein food, 1 cup of vegetables, 1 cup of fruit juice"));
        }

        else if (Integer.parseInt(r.get(r.size()-1))>=12){
            dietArrayList.add(new Diet("AGE --12 months and above","WHAT TO FEED --formula PLUS, soft cheese," +
                    " fruits cut into cubes, combo foods(macaroni), " +
                    "protein(medium bits of meat,bonny fish)",
                    "HOW TO FEED -- 1 cup of milk, 3 to 4 tablespoons of protein food, 1 cup of vegetables, 1 cup of fruit juice"));
        }

        else{
            dietArrayList.add(new Diet("AGE -- Birth to 4 months","WHAT TO FEED -- Breast milk or formula ONLY",
                    "HOW TO FEED -- Your baby digestive tract is still developing,so no solid food for now"));


            dietArrayList.add(new Diet("AGE -- 4 to 6 months","WHAT TO FEED -- Breast milk," +
                    " smashed sweet potatoes, apples and banana juice, beans soup, meat and chicken soup",
                    "HOW TO FEED -- Begin with about 1 teaspon pured food or cereal(beans) then you can increase to 1 " +
                            "tablespoon when the baby has gotten used"));

            dietArrayList.add(new Diet("AGE -- 6 to 8 months","WHAT TO FEED -- Breast milk, strained vegetables(well cooked carrots)," +
                    " oats porridge, meat soup(from pork, chicken, beef), small amount of unsweetened yogurt",
                    "HOW TO FEED -- 1 teaspoon fruit juice, 1 teaspoon vegetables, 3 to 9 tablespoons cereal"));

            dietArrayList.add(new Diet("AGE -- 8 to 10 months","WHAT TO FEED -- Breast milk, Mashed vegetables(well cooked carrots)," +
                    "Mashed fruits(bananas,peaches,pears), iron-fortified cereal(beans,wheat), small bits of meat, boneless fish",
                    "HOW TO FEED -- 1/4 cup of milk, 1/2 cup of iron-fortified cereal, 3/4 cup of fruit juice"));

            dietArrayList.add(new Diet("AGE -- 10 to 12 months","WHAT TO FEED -- Breast milk or formula PLUS, soft cheese," +
                    " fruits cut into cubes, combo foods(macaroni), " +
                    "protein(small bits of meat,boneless fish)",
                    "HOW TO FEED -- 1/3 cup of milk, 3 to 4 tablespoons of protein food, 3/4 cup of vegetables, 3/4 cup of fruit juice"));
        }



        mAdapter.notifyDataSetChanged();

    }
}
