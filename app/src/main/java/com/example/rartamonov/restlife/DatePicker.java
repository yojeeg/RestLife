package com.example.rartamonov.restlife;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.TextView;

import java.util.Calendar;

public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    public static final String TAG_WEIGHT_SELECTED = "weight";

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        Dialog picker = new DatePickerDialog(getActivity(), this,
                year, month, day);
        picker.setTitle(getResources().getString(R.string.choose_date));

        return picker;
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int year, int month, int day) {
        TextView tv = (TextView) getActivity().findViewById(R.id.tvDate);
        tv.setText(day + "-" + month + "-" + year);
        Intent intent = new Intent();
        intent.putExtra(TAG_WEIGHT_SELECTED, day + "-" + month + "-" + year);
        getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
    }

}
