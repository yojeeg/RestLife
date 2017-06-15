package com.example.rartamonov.restlife;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MonthsFragment extends Fragment {

    private Context context;

    GridView gvMonths;

    String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.months_frg, null);
        gvMonths = (GridView) v.findViewById(R.id.gvMonths);

        return v;
    }


    public void showGrid(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.months_item, R.id.tvText, months);
        gvMonths.setAdapter(adapter);
        adjustGridView();
    }

    private void adjustGridView() {
        gvMonths.setNumColumns(1);
        gvMonths.setColumnWidth(80);
        gvMonths.setVerticalSpacing(5);
        gvMonths.setHorizontalSpacing(5);
        gvMonths.setStretchMode(GridView.STRETCH_COLUMN_WIDTH );
    }
}
