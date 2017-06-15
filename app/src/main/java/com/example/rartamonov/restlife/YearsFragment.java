package com.example.rartamonov.restlife;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

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

        adapter = new ArrayAdapter<String>(context, R.layout.years_item, R.id.tvText, years){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {

                View root = super.getView(position, convertView, parent);
                if (position<=73) {
                    TextView textView = (TextView) root.findViewById(R.id.tvText);
                    //textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
                    textView.setTextColor(getResources().getColor(R.color.textGrid,context.getTheme()));
                } else if (position>73 && position<=75){
                    TextView textView = (TextView) root.findViewById(R.id.tvText);
                    textView.setTextColor(getResources().getColor(R.color.textGridTransperent1,context.getTheme()));
                } else if (position>75 && position<=77){
                    TextView textView = (TextView) root.findViewById(R.id.tvText);
                    textView.setTextColor(getResources().getColor(R.color.textGridTransperent2,context.getTheme()));
                } else if (position>77){
                    TextView textView = (TextView) root.findViewById(R.id.tvText);
                    textView.setTextColor(getResources().getColor(R.color.textGridTransperent3,context.getTheme()));
                }
                return root;
            }
        };
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
