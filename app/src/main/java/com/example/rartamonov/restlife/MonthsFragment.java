package com.example.rartamonov.restlife;

import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MonthsFragment extends Fragment {

    private Context context;

    private GridView gvMonths;

    private String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    final private Calendar c = Calendar.getInstance();
    final private int currentMonth = c.get(Calendar.MONTH);

    private Map<String, Integer> monthsMap = new HashMap<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();

        int i=0;
        for (String current:months){
            monthsMap.put(current,i);
            i++;
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.months_frg, null);
        gvMonths = (GridView) v.findViewById(R.id.gvMonths);

        return v;
    }


    public void showGrid(){
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.months_item, R.id.tvText, months){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                String valueCell = getItem(position).toString();

                int numberMonth = monthsMap.get(valueCell);

                View root = super.getView(position, convertView, parent);
                TextView textView = (TextView) root.findViewById(R.id.tvText);
                // сбросим все флаги
                textView.setPaintFlags( textView.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));

                if (numberMonth<currentMonth){
                    makeTextStrike(textView);
                }
                return root;
            }
        };
        gvMonths.setAdapter(adapter);
        adjustGridView();
    }

    public void makeTextStrike(TextView textView){
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    private void adjustGridView() {
        gvMonths.setNumColumns(1);
        gvMonths.setColumnWidth(80);
        gvMonths.setVerticalSpacing(5);
        gvMonths.setHorizontalSpacing(5);
        gvMonths.setStretchMode(GridView.STRETCH_COLUMN_WIDTH );
    }
}
