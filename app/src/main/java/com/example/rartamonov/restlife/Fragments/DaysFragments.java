package com.example.rartamonov.restlife.Fragments;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.rartamonov.restlife.R;

public class DaysFragments extends Fragment{

    private Context context;
    private TableLayout tableLayout;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.days_frg, null);
        tableLayout = (TableLayout) v.findViewById(R.id.tableLayout);
        return v;
    }

    public void showTableDays(){
        int ch=0;
        for (int i=1;i<=12;i++){
            TableRow tableRow = new TableRow(context);
            tableRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            for (int j=1;j<=31;j++){
                TextView textView = new TextView(context);
                if ((i==2)&&(j>28)){
                    textView.setText("");
                } else {
                    if (i<=7) {
                        if ((i % 2 == 0) && (j == 31)) {
                            textView.setText("");
                        } else{
                            textView.setText(String.valueOf(j));
                        }
                    }else {
                        if ((i % 2 != 0) && (j == 31)) {
                            textView.setText("");
                        } else {
                            textView.setText(String.valueOf(j));
                        }
                    }
                }
                ch++;
                tableRow.addView(textView,j-1);
            }
            tableLayout.addView(tableRow,i-1);
        }
    }
}
