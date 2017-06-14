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

    final private int AverageDurationLife = 65;
    private Context context;

    private static final int REQUEST_ARRAY = 1;

    //String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

    GridView gvMain;
    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        DateBornFragment dateBornFragment = new DateBornFragment();
        dateBornFragment.setTargetFragment(this, REQUEST_ARRAY);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.years_frg, null);
        gvMain = (GridView) v.findViewById(R.id.gvMain);

        return v;
    }

    public void showGrid(String[] years){

        adapter = new ArrayAdapter<String>(context, R.layout.years_item, R.id.tvText, years);
        gvMain.setAdapter(adapter);
        adjustGridView();

    }

    private void adjustGridView() {
        gvMain.setNumColumns(GridView.AUTO_FIT);
        gvMain.setColumnWidth(80);
        gvMain.setVerticalSpacing(5);
        gvMain.setHorizontalSpacing(5);
        gvMain.setStretchMode(GridView.STRETCH_COLUMN_WIDTH );
    }
}
