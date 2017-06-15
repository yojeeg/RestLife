package com.example.rartamonov.restlife.Fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.rartamonov.restlife.R;

public class DaysFragments extends Fragment{

    private Context context;
    private GridView gvDays;
    String[] days;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

        days = new String[372];
        int ch=0;
        for (int i=1;i<=12;i++){
            for (int j=1;j<=31;j++){
                if ((i==2)&&(j>28)){
                    days[ch]="";
                } else {
                    if (i<=7) {
                        if ((i % 2 == 0) && (j == 31)) {
                            days[ch] = "";
                        } else days[ch] = String.valueOf(j);
                    }else {
                        if ((i % 2 != 0) && (j == 31)) {
                            days[ch] = "";
                        } else days[ch] = String.valueOf(j);
                    }
                }
                ch++;
            }
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.days_frg, null);
        gvDays = (GridView) v.findViewById(R.id.gvDays);
        showGrid();
        return v;
    }

    public void showGrid(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.days_item, R.id.tvText, days);
        gvDays.setAdapter(adapter);
        adjustGridView();
    }

    private void adjustGridView() {
        gvDays.setNumColumns(31);
        gvDays.setColumnWidth(80);
        gvDays.setVerticalSpacing(5);
        gvDays.setHorizontalSpacing(5);
        gvDays.setStretchMode(GridView.STRETCH_SPACING_UNIFORM );
    }
}
