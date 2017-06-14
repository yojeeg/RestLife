package com.example.rartamonov.restlife;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class YearsFragment extends Fragment{

    private Context context;

    GridView gvYears;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.years_frg, null);
        gvYears = (GridView) v.findViewById(R.id.gvYears);

        return v;
    }

    public void showGrid(String[] years){

        adapter = new ArrayAdapter<String>(context, R.layout.years_item, R.id.tvText, years);
        gvYears.setAdapter(adapter);
        adjustGridView();

    }

    private void adjustGridView() {
        gvYears.setNumColumns(GridView.AUTO_FIT);
        gvYears.setColumnWidth(80);
        gvYears.setVerticalSpacing(5);
        gvYears.setHorizontalSpacing(5);
        gvYears.setStretchMode(GridView.STRETCH_COLUMN_WIDTH );
    }
}
