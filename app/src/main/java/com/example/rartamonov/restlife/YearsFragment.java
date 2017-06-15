package com.example.rartamonov.restlife;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Calendar;

public class YearsFragment extends Fragment{

    private Context context;

    GridView gvYears;
    ArrayAdapter<String> adapter;
    final Calendar c = Calendar.getInstance();
    int currentYear = c.get(Calendar.YEAR);

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

        adapter = new ArrayAdapter<String>(context, R.layout.years_item, R.id.tvText, years){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                String valueCell = getItem(position).toString();

                View root = super.getView(position, convertView, parent);
                if (valueCell.equals(String.valueOf(currentYear))) {
                    TextView textView = (TextView) root.findViewById(R.id.tvText);
                    textView.setTextColor(getResources().getColor(R.color.textGridCurrent, context.getTheme()));
                    makeTextStrike(valueCell, currentYear, textView);
                } else {
                    if (position <= 71) {
                        TextView textView = (TextView) root.findViewById(R.id.tvText);
                        //textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                        textView.setTextColor(getResources().getColor(R.color.textGrid, context.getTheme()));
                        makeTextStrike(valueCell, currentYear, textView);
                    } else if (position > 71 && position <= 73) {
                        TextView textView = (TextView) root.findViewById(R.id.tvText);
                        textView.setTextColor(getResources().getColor(R.color.textGridTransperent1, context.getTheme()));
                        makeTextStrike(valueCell, currentYear, textView);
                    } else if (position > 73 && position <= 75) {
                        TextView textView = (TextView) root.findViewById(R.id.tvText);
                        textView.setTextColor(getResources().getColor(R.color.textGridTransperent2, context.getTheme()));
                        makeTextStrike(valueCell, currentYear, textView);
                    } else if (position > 75 && position <= 77) {
                        TextView textView = (TextView) root.findViewById(R.id.tvText);
                        textView.setTextColor(getResources().getColor(R.color.textGridTransperent3, context.getTheme()));
                        makeTextStrike(valueCell, currentYear, textView);
                    } else if (position > 77) {
                        TextView textView = (TextView) root.findViewById(R.id.tvText);
                        textView.setTextColor(getResources().getColor(R.color.textGridTransperent4, context.getTheme()));
                        makeTextStrike(valueCell, currentYear, textView);
                    }
                }
                return root;
            }
        };
        gvYears.setAdapter(adapter);
        adjustGridView();

    }

    public void makeTextStrike(String value, int mYear, TextView textView){
        if (Integer.parseInt(value)<mYear){
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

    private void adjustGridView() {
        gvYears.setNumColumns(GridView.AUTO_FIT);
        gvYears.setColumnWidth(80);
        gvYears.setVerticalSpacing(5);
        gvYears.setHorizontalSpacing(5);
        gvYears.setStretchMode(GridView.STRETCH_COLUMN_WIDTH );
    }

}
