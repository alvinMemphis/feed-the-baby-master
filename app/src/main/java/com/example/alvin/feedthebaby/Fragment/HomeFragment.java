package com.example.alvin.feedthebaby.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.alvin.feedthebaby.topmenu.BabyCare;
import com.example.alvin.feedthebaby.topmenu.DailyActivity;
import com.example.alvin.feedthebaby.DatabaseHelper;
import com.example.alvin.feedthebaby.topmenu.Main3Activity;
import com.example.alvin.feedthebaby.Main5Activity;
import com.example.alvin.feedthebaby.R;


public class HomeFragment extends Fragment {
    DatabaseHelper DB;



    public HomeFragment() {
        // Required empty public constructor
    }
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_home, container, false);
        Button babycreate =(Button) view.findViewById(R.id.button2);
        babycreate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity().getApplicationContext(),Main5Activity.class);
                        startActivity(intent);
                    }

                }
        );
        Button babyedit=(Button) view.findViewById(R.id.button5);
        babyedit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity().getApplicationContext(),Main3Activity.class);
                        startActivity(intent);

                    }
                });
        Button daily=(Button) view.findViewById(R.id.button8);
        daily.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity().getApplicationContext(),DailyActivity.class);
                        startActivity(intent);

                    }
                });
        Button babycare=(Button) view.findViewById(R.id.button4);
        babycare.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent =new Intent(getActivity().getApplicationContext(),BabyCare.class);
                        startActivity(intent);

                    }
                });
        return view;

    }

}