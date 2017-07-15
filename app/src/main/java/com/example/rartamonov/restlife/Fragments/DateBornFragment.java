package com.example.rartamonov.restlife.Fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rartamonov.restlife.Dialogs.DatePicker;
import com.example.rartamonov.restlife.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateBornFragment extends Fragment{

    final private int averageDurationLife = 80;
    private static final int REQUEST_WEIGHT = 1;
    private Context context;
    private FragmentActivity fragmentActivity;
    TextView tv;
    private OnYearsFragmentInteractionListener mListener;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.date_born_frg, null);

        tv = (TextView)v.findViewById(R.id.tvDate);

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH)+1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        TextView tv = (TextView) v.findViewById(R.id.tvDate);
        tv.setText(day + "/" + month + "/" + year);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDatePicker();
            }
        });

        showYears(c.get(Calendar.YEAR),c.get(Calendar.MONTH)+1, c.get(Calendar.DAY_OF_MONTH));

        fragmentActivity = (FragmentActivity) getActivity();

        return v;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        context = getContext();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        String dateFormat = "dd/MM/yyyy";

        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_WEIGHT:
                    Long date = data.getLongExtra(DatePicker.TAG_DATE_SELECTED,0);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(date);
                    String res = formatter.format(calendar.getTime());
                    tv.setText(res);

                    // выведем список лет
                    showYears(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH)+1, calendar.get(Calendar.DAY_OF_MONTH));

                    break;
//                case REQUEST_ANOTHER_ONE:
//                    //...
//                    break;
//                //обработка других requestCode
            }
        }
    }

    public void openDatePicker(){
        DialogFragment dateDialog = new DatePicker();
        dateDialog.setTargetFragment(this, REQUEST_WEIGHT);
        dateDialog.show(fragmentActivity.getSupportFragmentManager(), dateDialog.getClass().getName());
    }

    public void showYears(int year, int month, int day){
        String[] years = new String[averageDurationLife];
        int currentYear = year;
        for (int i=0; i<averageDurationLife; i++){
            years[i]= String.valueOf(currentYear);
            currentYear++;
        }

        mListener.onYearsFragmentInteraction(years);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnYearsFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }
    public interface OnYearsFragmentInteractionListener {

        void onYearsFragmentInteraction(String[] link);
    }
}
