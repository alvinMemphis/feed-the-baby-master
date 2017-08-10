package com.example.alvin.feedthebaby.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alvin.feedthebaby.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {


    public ExploreFragment() {
        // Required empty public constructor
    }

    View view;
    LineChart lineChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_explore, container, false);
        lineChart = (LineChart) view.findViewById(R.id.lineChart);

        lineChart = (LineChart) view.findViewById(R.id.lineChart);

        ArrayList<Entry> yAXISsin = new ArrayList<>();
        ArrayList<Entry> yAXIScos = new ArrayList<>();

        double x = 0.0;
        int numDataPoints = 1000;

        for (int i = 0; i < numDataPoints; i++) {
            float sinFunction = Float.parseFloat(String.valueOf(Math.sin(x)));
            float cosFunction = Float.parseFloat(String.valueOf(Math.cos(x)));
            x = x + 0.1;
            float xEntry = Float.parseFloat(String.valueOf(x));
            yAXISsin.add(new Entry(xEntry, sinFunction));
            yAXIScos.add(new Entry(xEntry, cosFunction));


        }
        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
        LineDataSet lineDataSet1 = new LineDataSet(yAXIScos,"cos");
        LineDataSet lineDataSet2 = new LineDataSet(yAXISsin,"sin");

        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColors(Color.RED);
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setColors(Color.BLUE);

        lineDataSets.add(lineDataSet1);
        lineDataSets.add(lineDataSet2);

        lineChart.setData(new LineData(lineDataSets));
        lineChart.setVisibleXRangeMaximum(65f);

//can also try calling invalidate() to refresh the graph
        lineChart.invalidate();
        return view;
    }


}
