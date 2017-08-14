package com.example.alvin.feedthebaby;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main6Activity extends AppCompatActivity {
    //for database
    DatabaseHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        if(getIntent().hasExtra("com.example.alvin.feedthebaby.SOMETHING")){
            TextView tv = (TextView) findViewById(R.id.textView5);
            String text = getIntent().getExtras().getString("com.example.alvin.feedthebaby.SOMETHING");
            tv.setText(text);

        }
    }


   /* protected void onStart()
    {
        // TODO Auto-generated method stub
        super.onStart();
    }*/

}
