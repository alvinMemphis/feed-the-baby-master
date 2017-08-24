package com.example.alvin.feedthebaby.topmenu;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.alvin.feedthebaby.Baby;
import com.example.alvin.feedthebaby.R;
import com.example.alvin.feedthebaby.SQLiteHelper;
import com.example.alvin.feedthebaby.gopackage.ActivityBabyDiet;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class Main3Activity extends AppCompatActivity {
    Babyprofiles mBabyadapter;
    SQLiteHelper DB;


    public void createBay(Baby n) {
        // Temporary code
        mBabyadapter.addBaby(n);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mBabyadapter=new Babyprofiles();
        ListView lisbaby=(ListView)findViewById(R.id.listView);
        lisbaby.setAdapter(mBabyadapter);
        DB = new SQLiteHelper(Main3Activity.this);


    }
    public class Babyprofiles extends BaseAdapter {
        List<Baby> babyarray=new ArrayList<>();


        @Override
        public int getCount() {
            return babyarray.size();
        }

        @Override
        public Baby getItem(int whichitem) {
            return babyarray.get(whichitem);
        }

        @Override
        public long getItemId(int whichitem) {
            return whichitem;
        }

        @Override
        public View getView(int whichitem, View view, ViewGroup viewGroup) {



            if (view == null) {

                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                view = inflater.inflate(R.layout.list_vew, viewGroup, false);

            }

            ImageView babyImage=(ImageView)view.findViewById(R.id.thumbnail);
            TextView babyName =(TextView)findViewById(R.id.namebaby);
            TextView babyAge=(TextView)findViewById(R.id.agebaby);
            Baby tempbaby=babyarray.get(whichitem);
            babyName.setText(tempbaby.getName());
            babyAge.setText(tempbaby.getName());

            return view;
        }
        public void addBaby(Baby b){
            babyarray.add(b);

        }

    }

}

