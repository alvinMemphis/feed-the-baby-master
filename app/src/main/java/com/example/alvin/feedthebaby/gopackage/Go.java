package com.example.alvin.feedthebaby.gopackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.alvin.feedthebaby.R;

import java.util.ArrayList;

public class Go extends AppCompatActivity {
    CardView cd1,cd2,cd3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);
        cd1=(CardView)findViewById(R.id.cdBabyDiet);
        cd2=(CardView)findViewById(R.id.cdBabySchedule);
        cd3=(CardView)findViewById(R.id.cdAddActivity);
        cd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent diet=new Intent(getApplication(),ActivityBabyDiet.class);
                startActivity(diet);
            }
        });
        cd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent diet=new Intent(getApplication(),ActivitybabySchedule.class);
                startActivity(diet);
            }
        });
        cd3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent diet=new Intent(getApplication(),NewBabyactivity.class);
                startActivity(diet);
            }
        });

    }
}
