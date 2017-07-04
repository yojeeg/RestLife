package com.example.rartamonov.restlife.Fragments;

import android.content.Context;
import android.graphics.Paint;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.rartamonov.restlife.R;

import java.util.Calendar;

public class YearsFragment extends Fragment{

    private Context context;

    GridView gvYears;
    ProgressBar progressBar;
    ArrayAdapter<String> adapter;
    final private Calendar c = Calendar.getInstance();
    final private int currentYear = c.get(Calendar.YEAR);

    private OnMonthsFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnMonthsFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnYearsFragmentInteractionListener");
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.years_frg, null);
        gvYears = (GridView) v.findViewById(R.id.gvYears);
        progressBar = (ProgressBar)v.findViewById(R.id.progressBar);

        return v;
    }

    public void showGrid(String[] years){

        progressBar.setMax(years.length);
        progressBar.setProgress(currentYear-Integer.valueOf(years[0]));
        adapter = new ArrayAdapter<String>(context, R.layout.years_item, R.id.tvText, years){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                String valueCell = getItem(position).toString();

                View root = super.getView(position, convertView, parent);
                TextView textView = (TextView) root.findViewById(R.id.tvText);
                // сбросим все флаги
                textView.setPaintFlags( textView.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));

                if (valueCell.equals(String.valueOf(currentYear))) {
                    textView.setTextColor(getResources().getColor(R.color.textGridCurrent, context.getTheme()));
                    makeTextStrike(valueCell, currentYear, textView);
                } else {
                    if (position <= 71) {
                        //textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                        textView.setTextColor(getResources().getColor(R.color.textGrid, context.getTheme()));
                        makeTextStrike(valueCell, currentYear, textView);
                    } else if (position > 71 && position <= 73) {
                        textView.setTextColor(getResources().getColor(R.color.textGridTransperent1, context.getTheme()));
                        makeTextStrike(valueCell, currentYear, textView);
                    } else if (position > 73 && position <= 75) {
                        textView.setTextColor(getResources().getColor(R.color.textGridTransperent2, context.getTheme()));
                        makeTextStrike(valueCell, currentYear, textView);
                    } else if (position > 75 && position <= 77) {
                        textView.setTextColor(getResources().getColor(R.color.textGridTransperent3, context.getTheme()));
                        makeTextStrike(valueCell, currentYear, textView);
                    } else if (position > 77) {
                        textView.setTextColor(getResources().getColor(R.color.textGridTransperent4, context.getTheme()));
                        makeTextStrike(valueCell, currentYear, textView);
                    }
                }
                return root;
            }
        };
        gvYears.setAdapter(adapter);
        adjustGridView();
        mListener.onMonthsFragmentInteraction();

    }

    public void makeTextStrike(String value, int mYear, TextView textView){
        if (Integer.parseInt(value)<mYear){
            textView.setPaintFlags(textView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

    private void adjustGridView() {
        gvYears.setNumColumns(GridView.AUTO_FIT);
        gvYears.setColumnWidth(150);
        gvYears.setVerticalSpacing(5);
        gvYears.setHorizontalSpacing(5);
        gvYears.setStretchMode(GridView.STRETCH_COLUMN_WIDTH );
    }

    interface OnMonthsFragmentInteractionListener {

        void onMonthsFragmentInteraction();
    }
}
