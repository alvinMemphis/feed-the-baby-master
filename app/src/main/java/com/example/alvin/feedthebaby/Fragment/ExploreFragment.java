package com.example.alvin.feedthebaby.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alvin.feedthebaby.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {



    public ExploreFragment() {
        // Required empty public constructor
    }
    View view;
    LineGraphSeries<DataPoint> series;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_explore, container, false);
        double y, x;
        x = -5.0;

        GraphView graph = (GraphView) view.findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>();
        for (int i = 0; i < 100; i++) {
            x = x + 0.1;
            y = Math.sin(x);
            series.appendData(new DataPoint(x, y), true, 100);
        }
        graph.addSeries(series);

        return view;
    }

}

