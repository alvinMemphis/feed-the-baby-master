package com.example.alvin.feedthebaby.topmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.alvin.feedthebaby.gopackage.Go;
import com.example.alvin.feedthebaby.R;
import com.example.alvin.feedthebaby.WebViewexperiment;

public class DailyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily);
  /*      Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);*/

        Button babycreate =(Button) findViewById(R.id.button3);
        babycreate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getApplicationContext(),WebViewexperiment.class);
                        startActivity(intent);
                    }

                }
        );

    Button go=(Button)findViewById(R.id.button);
    go.setOnClickListener(
            new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent =new Intent(getApplicationContext(),Go.class);
            startActivity(intent);
        }

    }
        );
}
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
