package com.example.rartamonov.restlife.Fragments;

import android.graphics.Paint;
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

import java.util.Calendar;

public class DaysFragments extends Fragment{

    private Context context;
    private TableLayout tableLayout;
    final private Calendar c = Calendar.getInstance();
    final private int currentMonth = c.get(Calendar.MONTH);
    final private int currentDay = c.get(Calendar.DAY_OF_MONTH);

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
        tableLayout.removeAllViews();
        int ch=0;
        for (int i=1;i<=12;i++){
            TableRow tableRow = new TableRow(context);
            tableRow.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            for (int j=1;j<=31;j++){
                TextView textView = new TextView(context);
                textView.setPadding(5,2,5,2);
                textView.setTextColor(getResources().getColor(R.color.textGrid,context.getTheme()));
                textView.setTextSize(18);
                if (i<currentMonth+1){
                    makeTextStrike(textView);
                } else if ((i==currentMonth+1)&&(j<currentDay)){
                    makeTextStrike(textView);
                }

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

    public void makeTextStrike(TextView textView){
        textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }
}
