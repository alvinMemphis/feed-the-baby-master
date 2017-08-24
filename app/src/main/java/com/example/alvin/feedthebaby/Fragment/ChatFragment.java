package com.example.alvin.feedthebaby.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.alvin.feedthebaby.Baby;
import com.example.alvin.feedthebaby.R;
import com.example.alvin.feedthebaby.SQLiteHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {
    SQLiteHelper DB;
    TextView tv,tv2;
    View view;


    public ChatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //widgets
        DB = new SQLiteHelper(getContext().getApplicationContext());

        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_chat, container, false);

        tv = (TextView)view.findViewById(R.id.first_name);
        tv2 = (TextView) view.findViewById(R.id.first_age);

        List<Baby> c = DB.getAllRecords();
        ArrayList<String> ar = new ArrayList<String>();
        ArrayList<String> r = new ArrayList<String>();
        for (Baby num : c){
            ar.add(num.getName());
            r.add(num.getAge());
        }
        tv.setText(ar.get(ar.size()-1));
        tv2.setText(r.get(ar.size()-1));

        return view;
    }
}
